ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            GZIPInputStream gis = new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int len;
            while((len = gis.read(buffer)) != -1){                                        os.write(buffer, 0, len);
            }
            os.close();
            gis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        byte[] output = os.toByteArray();