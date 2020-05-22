IOUtils.copy(warFileInputStream, deployWarFileStdin);
deployWarFileStdin.close();
IOUtils.copy(deployWarFileStdout, System.out);

warFileInputStream.close();
deployWarFileStdout.close();