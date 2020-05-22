//Encode Video To String With mig Base64.

    File tempFile = new File(Environment.getExternalStorageDirectory()
                + "/my/part/my_0.mp4");
        String encodedString = null;

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(tempFile);
        } catch (Exception e) {
            // TODO: handle exception
        }
        byte[] bytes;
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bytes = output.toByteArray();
        encodedString = Base64.encodeToString(bytes, true);
        Log.i("Strng", encodedString);


//Decode String To Video With mig Base64.
        byte[] decodedBytes = Base64.decodeFast(encodedString.getBytes());

        try {

            FileOutputStream out = new FileOutputStream(
                    Environment.getExternalStorageDirectory()
                            + "/my/Convert.mp4");
            out.write(decodedBytes);
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("Error", e.toString());

        }