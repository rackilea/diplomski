//1. Convert JSON to Java object
ObjectMapper mapper = new ObjectMapper();
User user = mapper.readValue(new File("c:\\report_data.json"), ReportData.class);

//2. Convert Java object to JSON format
ObjectMapper mapper = new ObjectMapper();
mapper.writeValue(new File("c:\\report_data.json"), reportData);