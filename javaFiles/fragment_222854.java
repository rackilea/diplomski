for (File file : dir) {
            if (!loaded.contains(file.getName())) {
                long filesize = 0;
                boolean cont = true;
                while (cont) {
                    if (file.length() == filesize) {
                        cont = false;
                        Thread.sleep(3);
                        filesToLoad.add(file);
                    }
                    else {
                        filesize = file.length();
                        Thread.sleep(3);
                    }
                }
                Thread.sleep(3);
            }
        }