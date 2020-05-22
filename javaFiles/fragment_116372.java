proc = Runtime.getRuntime().exec(cmds);
            PrintStream pw = new PrintStream(proc.getOutputStream());
            FetcherListener fl = new FetcherListener() {

                @Override
                public void fetchedMore(byte[] buf, int start, int end) {
                    textOut.println(new String(buf, start, end - start));
                }

                @Override
                public void fetchedAll(byte[] buf) {
                }           
            };
            IOUtils.loadDataASync(proc.getInputStream(), fl);
            IOUtils.loadDataASync(proc.getErrorStream(), fl);
            String home = System.getProperty("user.home");
            //System.out.println("home: " + home);
            String profile = IOUtils.loadTextFile(new File(home + "/.profile"));
            pw.println(profile);
            pw.flush();