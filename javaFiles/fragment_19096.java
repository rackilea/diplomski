List<String> coockies = t.postForEntity(loginUrl, remoteSessionPacket, String.class)
            .getHeaders()
            .get("Set-Cookie");

    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.put(HttpHeaders.COOKIE, coockies);
    HttpEntity<Void> requestEntity = new HttpEntity<>(requestHeaders);