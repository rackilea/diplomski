try {
            channel.connect();
            logger.info("shell channel connected....");             
        } catch(JSchException e) {
            logger.warning("Could not connect: " + e.toString());
            logStreamForEmail.close();

        }

        if (!channel.isConnected()) {

            // Close the log stream for email.  This causes it to write all output to the Byte Array Output Stream, which we can dump into email Body Texts
            logStreamForEmail.close();

            // Send warning email, could not connect
            new SendEmail(warningEmailAddress, "SFTP Warning: Could not connect to host", baosForEmail.toString());
        } else {   
            try {   
                ChannelSftp c = (ChannelSftp) channel;   
                c.lcd(localDir);
                logger.info("lcd " + c.lpwd());

                // Get a listing of the remote directory
                @SuppressWarnings("unchecked")
                Vector<ChannelSftp.LsEntry> list = c.ls("."); 
                logger.info("ls .");

                // iterate through objects in list, identifying specific file names
                for (ChannelSftp.LsEntry oListItem : list) {
                    // output each item from directory listing for logs
                    logger.info(oListItem.toString()); 

                    // If it is a file (not a directory)
                    if (!oListItem.getAttrs().isDir()) {
                        // Grab the remote file ([remote filename], [local path/filename to write file to])

                        logger.info("get " + oListItem.getFilename());
                        c.get(oListItem.getFilename(), oListItem.getFilename());  // while testing, disable this or all of your test files will be grabbed

                        grabCount++; 

                        // Delete remote file
                        //c.rm(oListItem.getFilename());  // Note for SFTP grabs from this remote host, deleting the file is unnecessary, 
                                                          //   as their system automatically moves an item to the 'downloaded' subfolder
                                                          //   after it has been grabbed.  For other target hosts, un comment this line to remove any downloaded files from the inbox.
                    }
                }

                // Report files grabbed to log
                if (grabCount == 0) { 
                    logger.info("Found no new files to grab.");
                } else {
                    logger.info("Retrieved " + grabCount + " new files.");
                }                           
            } catch(SftpException e) {
                logger.warning(e.toString());
            } finally {
                // disconnect session.  If this is not done, the job will hang and leave log files locked
                session.disconnect();
                logger.info("Session Closed");
            }