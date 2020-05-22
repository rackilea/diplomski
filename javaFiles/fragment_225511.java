..stuff...

TransferManager tm = TransferManagerBuilder
                        .standard()
                        .withS3Client(s3Client)                    
                        .build();

LocalDateTime uploadStartedAt = LocalDateTime.now();
log.info("Starting to upload " + FileUtils.byteCountToDisplaySize(fileSize));

Upload up = tm.upload(bucketName, file.getName(), file);

awsHoldUntilCompletedAndShowTransferProgress(up);

log.info("Time consumed: " + DurationFormatUtils.formatDuration(Duration.between(uploadStartedAt, LocalDateTime.now()).toMillis(), "dd HH:mm:ss"));