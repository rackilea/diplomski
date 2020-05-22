if (isJPEG(path))
        {
            fis = new FileInputStream(path);
            bytes = new byte[(int)(new File(path).length())];
            APP0 = hexStringToByteArray(APP0Marker.replaceAll(" ", ""));

            for (int index = 0; index < bytes.length; index++)
            {
                if (index >= 2 && index <= (2 + APP0.length - 1))
                {
                    b = APP0[index-2];
                }
                else
                {
                    b = (byte) fis.read();
                }//if-else

                bytes[index] = b;
            }//for

            //Write new image file
            out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
        }//if