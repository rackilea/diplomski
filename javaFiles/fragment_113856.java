StreamingOutput stream = new StreamingOutput() {
              @Override
              public void write(OutputStream output) throws IOException {
                try {      
                ObjectMapper mapper = new ObjectMapper(new BsonFactory());
                mapper.writeValue(output, responseChipoutImage);
                } catch (Exception e) {
                   e.printStackTrace();
                }
              }
            };