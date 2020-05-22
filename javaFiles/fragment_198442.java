for (Part part : request.getParts()) {
            fileName = getFileName(part);
            if (fileName != null && !"".equals(fileName)) {
                part.write(UploadFilePath + File.separator + fileName);
            }

        }