ObjectMapper mapper = new ObjectMapper();
Response response = mapper.readValue(jsonStr, Response.class);

String givenDate = "2019-11-21 12:00:00";
response.getList().forEach(e -> {
    if (givenDate.equals(e.getDtTxt())) {
        System.out.println("temp: " + e.getMain().get("temp").asText());
        System.out.println("wind speed:" + e.getWind().get("speed").asText());
    }
});