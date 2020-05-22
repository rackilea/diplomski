private UsernamePasswordAuthenticationToken getUserNamePasswordAuthenticationToken(HttpServletRequest request)  throws IOException{
    StringBuffer sb = new StringBuffer();
    BufferedReader bufferedReader = null;
    String content = "";
    LoginRequest sr = null;

    try {
        bufferedReader =  request.getReader()
        char[] charBuffer = new char[128];
        int bytesRead;
        while ( (bytesRead = bufferedReader.read(charBuffer)) != -1 ) {
            sb.append(charBuffer, 0, bytesRead);
        }
        content = sb.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            sr = objectMapper.readValue(content, LoginRequest.class);
        }catch(Throwable t){
            throw new IOException(t.getMessage(), t);
        }
    } catch (IOException ex) {

        throw ex;
    } finally {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                throw ex;
            }
        }
    }
    return new UsernamePasswordAuthenticationToken(sr.getEmail(), sr.getPassword());