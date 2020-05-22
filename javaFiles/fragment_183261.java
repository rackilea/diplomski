Vector<ChannelSftp.LsEntry> list = sftpChannel .ls("."); 
    // iterate through objects in list, and check for extension
    for (ChannelSftp.LsEntry listEntry : list) {
            sftpChannel.get(listEntry.getFilename(), "fileName"); 

        }
    }