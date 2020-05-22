private String determineContentType(String fileName) {
        String contentType;

        if (fileName.contains(".txt")) {
            contentType = "text/plain; charset=" + mailProperties.getEncoding();
        }
        else if (fileName.contains(".xls")) {
            contentType = "application/vnd.ms-excel; charset=" + mailProperties.getEncoding();
        }
        else if (fileName.contains(".pdf")) {
            contentType = "application/pdf; charset=" + mailProperties.getEncoding();
        }
        else if (fileName.contains(".doc")) {
            contentType = "application/msword; charset=" + mailProperties.getEncoding();
        }
        else if (fileName.contains(".xml")) {
            contentType = "text/xml; charset=" + mailProperties.getEncoding();
        }
        else if (fileName.contains(".zip")) {
            contentType = "application/zip; charset=" + mailProperties.getEncoding();
        }
        else {
            contentType = "text/plain; charset=" + mailProperties.getEncoding();
        }
        return contentType;
    }