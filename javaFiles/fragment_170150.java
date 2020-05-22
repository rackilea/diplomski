while (count < totalCount ) {
                MyClient check = new MyClient();
                check.checkSecurity();

                System.out.println(" ************ Starting with count " + count + " ***********************");
                URI uriBuilder = new URIBuilder(url)
               .addParameter("limit", String.valueOf(limit))
               .addParameter("offset", String.valueOf(offset))
                .build();   

                System.out.println("The URL built is --> " + uriBuilder); 
                HttpGet hget = new HttpGet(uriBuilder);
                System.out.println(hget.getRequestLine());

        CloseableHttpClient httpclient = HttpClients.createDefault();
                hget.addHeader("Content-Type", "application/json");             

                HttpResponse response = httpclient.execute(hget);                                       
                    URL vdbUrl = uriBuilder.toURL();
                    System.out.println("Response status : " + response.getStatusLine());
                    HttpEntity entity2 = response.getEntity();

                    do {
                        vdbInput = new File("C:/myfiles/entry_0" + filenamePostfix + ".json");
                        FileUtils.copyURLToFile(vdbUrl, vdbInput);        
                        System.out.println("File successfully written from page " +  count );
                        System.out.println("page is : "  + vdbUrl);
                        filenamePostfix++;                                                  
                        count++;
                        offset = offset + 20;

                    } while (filenamePostfix < count) ;

                    EntityUtils.consume(entity2);
                }
        }