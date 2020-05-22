public void getCanvas(){
       JsonFactory jsonFactory = new JsonFactory();
        String canvas = "";
        try {
            JsonParser jsonParser = jsonFactory.createJsonParser(new URL(canvasURL));
            JsonToken token = jsonParser.nextToken();
            while (token!=JsonToken.START_ARRAY && token != null){
                token = jsonParser.nextToken();

                // if we already passed last token,
                // break, don't print it out unnecessarily
                if (token == null) break;

                System.out.println("Token is "+ token);
            }
            while (token != JsonToken.END_ARRAY){
                token = jsonParser.nextToken();
                if(token == JsonToken.START_OBJECT){
                   canvas  = jsonParser.toString();
// I also tried token.toString
                    System.out.println("Canvas is "+canvas);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }