if (path.equals("")) {
                addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip, false);
            } else {
                if (rootDirectory) {
                    addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip, false);
                } else {
                    addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip, false);
                }
            }