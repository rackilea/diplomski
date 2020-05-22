/**
     *
     * @param reader The InputStreamReader that contains the data that is used to parse the file
     * @param fileName the filename WITH extension
     */
        public void saveToCache(final Reader reader, String fileName){
            System.out.println("Saving item to cache");



            final File file = new File(context.getApplicationContext().getCacheDir(), fileName);

            System.out.println("file.getPath() = " + file.getPath());

            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(reader == null){
                System.err.println("reader == null!!");
            }

            Thread writeCache = new Thread(){

                @Override
                public void run(){
                    try {
                        System.out.println("Writing file!");
                        OutputStream outStream;
                        outStream = new BufferedOutputStream(new FileOutputStream(file));

                        BufferedReader bufferedReader = new BufferedReader(reader);
                        String line = null;

                        while ((line = bufferedReader.readLine()) != null){
                            outStream.write(line.getBytes());
                        }

                        outStream.flush();
                        outStream.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            };

            writeCache.run();

            System.out.println("savedItemToCache");
        }