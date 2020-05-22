MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create(); // init builder

multipartEntityBuilder.addBinaryBody("pdfFile", data, ContentType.create("application/octet-stream"),
            "pdfFile");
multipartEntityBuilder.setBoundary("---Content Boundary");
HttpEntity entity = multipartEntityBuilder.build();