@Bean
public IntegrationFlow ftpInboundFlow() {
    return IntegrationFlows
        .from(source -> source.ftp(ftpSessionFactory()).deleteRemoteFiles(true).preserveTimestamp(true)
                .filter(compositeWithAcceptOnceFilter())                        .remoteDirectory(ftpProperties.getRemoteDirectory())
                .localDirectory(new File(ftpProperties.getLocalDirectory())).autoCreateLocalDirectory(true),
        consumer -> consumer.id("ftpInboundAdapter")) /* Fine from() */
        .handle(new GenericHandler<File>() {

            @Override
            @Transactional
            public Object handle(File payload, Map<String, Object> headers) {
                logger.debug("Data arrived {} {}", payload, payload.getClass().getName());
                /* handle file content here ... */
                /* ... then move it to archive */
                File dstFile = new File("archive", payload);
                FileUtils.moveFile(payload, dstFile);
                return dstFile;
            }

        }) /* Fine GenericHandler */
        /* Archive the remote file */
        .handleWithAdapter(a -> a.ftp(ftpSessionFactory())
                .remoteDirectory(ftpProperties.getRemoteArchiveDirectory()).autoCreateDirectory(true))              
        .get();