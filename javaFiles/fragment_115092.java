public class FtpUpdatingFileSynchronizer extends FtpInboundFileSynchronizer {

    protected final Log logger = LogFactory.getLog(this.getClass());

    private volatile Expression localFilenameGeneratorExpression;
    private volatile EvaluationContext evaluationContext;
    private volatile boolean deleteRemoteFiles;
    private volatile String remoteFileSeparator = "/";
    private volatile boolean  preserveTimestamp;

    public FtpUpdatingFileSynchronizer(SessionFactory<FTPFile> sessionFactory) {
        super(sessionFactory);
        setPreserveTimestamp(true);
    }

    @Override
    public void setLocalFilenameGeneratorExpression(Expression localFilenameGeneratorExpression) {
        super.setLocalFilenameGeneratorExpression(localFilenameGeneratorExpression);
        this.localFilenameGeneratorExpression = localFilenameGeneratorExpression;
    }

    @Override
    public void setIntegrationEvaluationContext(EvaluationContext evaluationContext) {
        super.setIntegrationEvaluationContext(evaluationContext);
        this.evaluationContext = evaluationContext;
    }

    @Override
    public void setDeleteRemoteFiles(boolean deleteRemoteFiles) {
        super.setDeleteRemoteFiles(deleteRemoteFiles);
        this.deleteRemoteFiles = deleteRemoteFiles;
    }

    @Override
    public void setRemoteFileSeparator(String remoteFileSeparator) {
        super.setRemoteFileSeparator(remoteFileSeparator);
        this.remoteFileSeparator = remoteFileSeparator;
    }

    @Override
    public void setPreserveTimestamp(boolean preserveTimestamp) {
        // updated
        Assert.isTrue(preserveTimestamp, "for updating timestamps must be preserved");
        super.setPreserveTimestamp(preserveTimestamp);
        this.preserveTimestamp = preserveTimestamp;
    }

    @Override
    protected void copyFileToLocalDirectory(String remoteDirectoryPath, FTPFile remoteFile, File localDirectory,
            Session<FTPFile> session) throws IOException {

        String remoteFileName = this.getFilename(remoteFile);
        String localFileName = this.generateLocalFileName(remoteFileName);
        String remoteFilePath = (remoteDirectoryPath != null
                ? (remoteDirectoryPath + this.remoteFileSeparator + remoteFileName)
                        : remoteFileName);

        if (!this.isFile(remoteFile)) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("cannot copy, not a file: " + remoteFilePath);
            }
            return;
        }

        // start update
        File localFile = new File(localDirectory, localFileName);
        boolean update = false;
        if (localFile.exists()) {
            if (this.getModified(remoteFile) > localFile.lastModified()) {
                this.logger.info("Updating local file " + localFile);
                update = true;
            } else {
                this.logger.info("File already exists: " + localFile);
                return;
            }
        }
        // end update

        String tempFileName = localFile.getAbsolutePath() + this.getTemporaryFileSuffix();
        File tempFile = new File(tempFileName);
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tempFile));
        try {
            session.read(remoteFilePath, outputStream);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
            else {
                throw new MessagingException("Failure occurred while copying from remote to local directory", e);
            }
        } finally {
            try {
                outputStream.close();
            }
            catch (Exception ignored2) {
            }
        }
        // updated
        if (update && !localFile.delete()) {
            throw new MessagingException("Unable to delete local file [" + localFile + "] for update.");
        }
        if (tempFile.renameTo(localFile)) {
            if (this.deleteRemoteFiles) {
                session.remove(remoteFilePath);
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("deleted " + remoteFilePath);
                }
            }
            // updated
            this.logger.info("Stored file locally: " + localFile);
        } else {
            // updated
            throw new MessagingException("Unable to rename temporary file [" + tempFile + "] to [" + localFile + "]");
        }
        if (this.preserveTimestamp) {
            localFile.setLastModified(getModified(remoteFile));
        }
    }

    private String generateLocalFileName(String remoteFileName) {

        if (this.localFilenameGeneratorExpression != null) {
            return this.localFilenameGeneratorExpression.getValue(this.evaluationContext, remoteFileName, String.class);
        }
        return remoteFileName;
    }

}