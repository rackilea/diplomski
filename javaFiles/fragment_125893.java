private String getTokenString(@NonNull String code)
    {
        String tokenUrl = AZURE_BASE_URL + tenantId + "/oauth2/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //headers.set("Authorization", "Bearer "+code);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type","authorization_code");
        requestBody.add("client_id",clientId);
        requestBody.add("code",code);
        requestBody.add("client_secret",password);
        requestBody.add("redirect_uri",redirectUrl);

        HttpEntity<MultiValueMap> entity = new HttpEntity<MultiValueMap>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, entity, String.class);
            System.out.println(response.getBody());
            return response.getBody();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }