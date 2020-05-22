reader = new BufferedReader(new InputStreamReader(response.getInputStream()));
    char[] chars = new char[2048];
    int charsRead = 0;
    while ((charsRead = reader.read(chars)) != -1) {
        jsonResponse.append(chars, 0, charsRead);
        //no need to clear char[]
    }