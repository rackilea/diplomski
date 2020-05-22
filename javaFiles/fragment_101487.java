class EsUtils {

  public static Client client

  public static void applyMapping(String index, String type, String location) throws Exception {

            String source = readJsonDefn(location);

            if (source != null) {
                PutMappingRequestBuilder pmrb = client.admin().indices()
                                                      .preparePutMapping(index)
                                                      .setType(type);
                pmrb.setSource(source);
                MappingListener mappingListener = new MappingListener(pmrb)

                // Create type and mapping
                Thread thread = new Thread(mappingListener)

                thread.start();
                while (!mappingListener.processComplete.get()) {
                    System.out.println("not complete yet. Waiting for 100 ms")
                    Thread.sleep(100);

                }

            } else {
                   System.out.println("mapping error");
            }

       }

       public static String readJsonDefn(String url) throws Exception {
                 //implement it the way you like 
              StringBuffer bufferJSON = new StringBuffer();

              FileInputStream input = new FileInputStream(new File(url).absolutePath);
              DataInputStream inputStream = new DataInputStream(input);
              BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

              String line;

              while ((line = br.readLine()) != null) {
                             bufferJSON.append(line);
              }
              br.close();
              return bufferJSON.toString();
       }
    }