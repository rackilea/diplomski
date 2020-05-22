RestTemplate rt = new RestTemplate();

rt.setMessageConverters(
        Arrays.asList(new HttpMessageConverter[]{new FormHttpMessageConverter(), new StringHttpMessageConverter()}));

MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
map.add("some", someDataObject.getSomeProperty().toString());
map.add("another", someDataObject.getAnotherProperty().toString());

String resp = rt.postForObject("http://scooterlabs.com/echo", map, String.class);

System.out.println(resp);