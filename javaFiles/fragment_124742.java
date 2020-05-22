public boolean copyFiles(FileInputStream file, String fileName) {
            boolean successful = false;
            int cursor;
            SmbFileOutputStream sfos;
            SmbFile sFile;
            String path;
            NtlmPasswordAuthentication auth;
            try{
                String user = USER_NAME + ":" + PASSWORD;
                System.out.println("User: " + user);

                 auth = new NtlmPasswordAuthentication(user);
                StrictMode.ThreadPolicy tp = StrictMode.ThreadPolicy.LAX; StrictMode.setThreadPolicy(tp);

                 path = NETWORK_FOLDER + fileName+".jpeg";
                System.out.println("Path: " +path);

                 sFile = new SmbFile(path, auth);
                 sfos = new SmbFileOutputStream(sFile);

                long t0 = System.currentTimeMillis();

                byte[] b = new byte[8192];
                int n, tot = 0;
                Log.d("asdf","initiating : total="+tot);


                while((n = file.read(b))>0){
                    sfos.write( b, 0, n );
                    tot += n;
                    Log.d("asdf","writing : total="+tot);
                }
                successful = true;
                Log.d("asdf","Successful : total="+tot);

            }

            catch (Exception e) {
                successful = false;
                e.printStackTrace();
                Log.d("asdf","exxeption ");

            }
            return successful;
        }