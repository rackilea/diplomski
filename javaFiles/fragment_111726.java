public static String convertXMLtoJson( String inputxml) {
         String json="";
         try {
             ObjectMapper objectMapper = new XmlMapper();
             ObjectMapper jsonMapper = new ObjectMapper();
            Employee emp = objectMapper.readValue(inputxml, Employee.class);
          json =jsonMapper.writeValueAsString(emp);
            System.out.println(jsonMapper.writeValueAsString(emp));
         } catch (Exception e) {
             e.printStackTrace();
         }
         return json;
     }