URL u = new URL(url);
                        HttpURLConnection c = (HttpURLConnection) u.openConnection();

                        URLConnection conn = u.openConnection();

                        fs = conn.getContentLength();

                        c.setRequestMethod("GET");
                        c.setDoOutput(true);
                        c.connect();

                        String PATH_op = Environment.getExternalStorageDirectory() 
                                +"//"+ filename;

                        f = new FileOutputStream(new File(PATH_op));

                        InputStream in = c.getInputStream();

                        byte[] buffer = new byte[1024];

                        int len1 = 0;

                        while ( (len1 = in.read(buffer)) > 0 ) {
                            f.write(buffer,0, len1);
                            completed += len1; 
                        }

                        f.close();`enter code here`