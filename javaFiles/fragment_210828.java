try {
            Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                        .setApplicationName("xyz")
                        .build();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            service.files().export(fileId, "application/pdf")
                .executeMediaAndDownloadTo(outputStream);
            int fileSize = outputStream.toByteArray().length;
        } catch (Exception ex) {

        }