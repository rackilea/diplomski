String filePath = "C:\\Users\\xyz\\Desktop\\";
        String originalFileName = "96172560100_copy2.pdf";
        String newFileName = "test.pdf";

        byte[] input_file = Files.readAllBytes(Paths.get(filePath+originalFileName));

        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
        String encodedString =  new String(encodedBytes);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString.getBytes());

        FileOutputStream fos = new FileOutputStream(filePath+newFileName);
        fos.write(decodedBytes);
        fos.flush();
        fos.close();