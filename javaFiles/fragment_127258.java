public String getCountryCode() {
 String endpoint = "http://api.ipinfodb.com/v3/ip-country/?key=62ee2a10303261af0cf55d6eb2c807c8db5e6fa539fe5ba843c341f4062bfaea&ip= " + this.getIp();
 RestTemplate restTemplate = new RestTemplate();
 String countryCode = restTemplate.getForObject(endpoint, String.class).split(";")[3];
 return countryCode;
}