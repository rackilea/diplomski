fileOutputStream fos = new FileOutputStream(path);
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        gzip.write(shortToBytes(numImatges));
        gzip.write(shortToBytes((short) 0));     
        for (int i = 0; i < dates.getNB_OF_IMAGES(); i++) {

            if (images != null) {
                im = images.get(i).getBufImg();
            }
            ByteArrayOutputStream byteOstream = new ByteArrayOutputStream();
            ImageIO.write(im, "jpeg", byteOstream);
            byteOstream.flush();
            byteOstream.close();
            gzip.write(shortToBytes((short) byteOstream.size()));
            gzip.write(byteOstream.toByteArray());


            }
//close streams