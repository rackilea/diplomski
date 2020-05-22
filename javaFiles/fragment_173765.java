try {
            channelTarget.put(get, completeBackupPath + fileName);
        } catch (SftpException e) {
            System.out.println("Creating Directory...");
            String[] complPath = completeBackupPath.split("/");
            channelTarget.cd("/");
            for (String dir : complPath) {
                if (folder.length() > 0) {
                    try {
                        System.out.println("Current Dir : " + channelTarget.pwd());
                        channelTarget.cd(folder);
                    } catch (SftpException e2) {
                        channelTarget.mkdir(folder);
                        channelTarget.cd(folder);
                    }
                }
            }
            channelTarget.cd("/");
            System.out.println("Current Dir : " + channelTarget.pwd());
            channelTarget.put(get, completeBackupPath + fileName);
        }