File file = new File("a.bson");
        String path = "b.bson";
        BasicBSONEncoder encoder =  new BasicBSONEncoder();
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        BSONDecoder decoder = new BasicBSONDecoder();  
        try {
            while (inputStream.available() > 0) {
                BSONObject bsonSingleRow = decoder.readObject(inputStream);                
                c = bsonSingleRow.get("yourKey").toString();
                    if (Math.random()> .98))
                    Files.write(Paths.get(path), encoder.encode(bsonSingleRow),StandardOpenOption.CREATE, StandardOpenOption.APPEND);                        
                }                                                
            }
        } catch (IOException e) {
            ...
        }