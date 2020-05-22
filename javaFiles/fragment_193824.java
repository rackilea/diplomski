public class MailServiceHelper {
    public String getJsp(String url, Map<String,String> form, HttpServletRequest request) {
        //we can figure out the base url from the request
        String baseUrl =""; 
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(baseUrl+"/"+url);
        for (String formElement : form.keySet()) {
            method.setParameter(formElement, form.get(formElement));    
        }

        try {

            int statusCode = client.executeMethod(method);
            if (statusCode >= HttpStatus.SC_OK && statusCode < HttpStatus.SC_MULTIPLE_CHOICES) {
                byte[] responseBody = method.getResponseBody();     
                return new String(responseBody,StandardCharsets.UTF_8);
            }else{
                throw new RuntimeException("Failed to read jsp, server returened with status code: "+statusCode);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read jsp",e);
        }finally{
            method.releaseConnection();
        }
    }