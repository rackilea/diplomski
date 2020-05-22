if (file.isDirectory())
            {
                // Change working Directory to this directory.
                ftpClient.changeWorkingDirectory(file.getName());

                // Create the directory locally - in the right place
                File newDir = new File (base + "/" + ftpClient.printWorkingDirectory());
                newDir.mkdirs();

                // Recursive call to this method.
                download(ftpClient.printWorkingDirectory(), base);

                // Come back out to the parent level.
                ftpClient.changeToParentDirectory();
            }