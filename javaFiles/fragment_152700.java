psmnt = conn.prepareStatement("INSERT INTO upload_data(user_id,audiofile) "
                            + "values(?,?)");

            psmnt.setLong(1, userId);

            fis = new FileInputStream(audioFile);
            psmnt.setBinaryStream(2, (InputStream) fis, (int) (audioFile
                    .length()));
            /*
             * executeUpdate() method execute specified sql query. Here this
             * query insert data and image from specified address.
             */
            int s = psmnt.executeUpdate();