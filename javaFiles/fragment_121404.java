byte[] buffer = new byte[0xFFFF];

                    while ((n = in1.read(buffer)) != -1)
                    {
                        bos.write(buffer, 0, n);
                    }