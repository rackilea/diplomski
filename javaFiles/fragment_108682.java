if (folder.getAbsolutePath().substring(folder.getAbsolutePath().indexOf(".")).equals(".xml")) {
                // save xml File in root directory
                zip.putNextEntry(new ZipEntry(folder.getName()));
            } else {
                zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
            }