RestTemplate restTemplate = new RestTemplate();
HeartBeat heartBeat = new HeartBeat(appPreferences.getInt("UnitId"), (short) bM.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY), (short) myPhoneStateListener.getSignalStrength(), mSignalType);
restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.setAccept(Arrays.asList(new MediaType("application", "json", Charset.forName("UTF-8"))));
try {
    HttpEntity<HeartBeat> entityHeartBeat = new HttpEntity<>(heartBeat, httpHeaders);
    ResponseEntity<String> responseEntity = restTemplate.exchange(url + "SendHeartBeat",
                    HttpMethod.POST, entityHeartBeat, String.class);
    return responseEntity.getBody();
} catch (Exception e) {
    Log.e("SiteConnection", ">>>>>>>>>>>>>>>> " + e.getLocalizedMessage());
    e.printStackTrace();
}