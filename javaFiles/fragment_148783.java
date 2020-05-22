/**
         *
         * @param fileName the filename WITH extension
         * @return The reader that you can use to parse the file
         * @throws ExecutionException
         * @throws InterruptedException
         */
            public Reader getFromCache(String fileName) throws ExecutionException, InterruptedException {
                BufferedReader reader = null;

                System.out.println("getFromCache");

                final File file = new File(context.getApplicationContext().getCacheDir(), fileName);

                try {
                      FileInputStream inStream = new FileInputStream(file);
                      reader = new BufferedReader(new InputStreamReader(inStream));

                } catch (FileNotFoundException e) {
                      e.printStackTrace();
                }

                System.out.println("Reading from cache finished");

                return reader;
            }