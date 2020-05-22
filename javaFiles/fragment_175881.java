int a = 454545454;
        String data = String.valueOf(a);
        try {
            byte[] bytesdata = data.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }