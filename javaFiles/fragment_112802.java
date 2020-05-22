// Read the response body.
  byte[] responseBody = method.getResponseBody();

  // Deal with the response.
  // Use caution: ensure correct character encoding and is not binary data
  System.out.println(new String(responseBody));