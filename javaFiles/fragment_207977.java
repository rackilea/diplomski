private String getMessage(InputStream in) throws IOException {

            StringBuilder sb = new StringBuilder();

            int pom;

            while((pom = in.read()) != -1){             
               char znak = (char) pom;
               sb.append(znak);                   
               if ( sb.charAt(0) != 'I')
                   break;
               if (sb.toString().contains("\r\n")) {                  
                      String result = sb.toString();                                       
                      result = result.replace("\r\n", "");
                      return result;
               }
            }   
            return null;
       }