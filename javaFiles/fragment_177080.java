RestTemplate requestTemplate = new RestTemplate();
    Login responseEntity=null;
            try {
                 responseEntity = restTemplate.postForObject("/http:localhost:8080/login", login,
                        Login.class);
            } catch (Exception e) {
            }
            return responseEntity;