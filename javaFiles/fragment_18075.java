MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
map.add("username", "roy");
map.add("password", "spring");
map.add("grant_type", "password");
map.add("scope", "read write");
map.add("client_secret","123456");
map.add("client_id","clientapp");           

HttpEntity request = new HttpEntity(map, headers);