req.setCharacterEncoding("UTF-8");
public String getXML(HttpServletRequest req) throws IOException{    
    String input = null;
    if ((input = (String) req.getAttribute("com.xp.input")) == null) {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();

        String line;
        while((line = reader.readLine()) != null){
            buffer.append(line);
        }
        input = buffer.toString();
        req.setAttribute("com.xp.input", input);
    }
    if (input == null) {
        return "";
    } 
    String header = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
    String body = input.substring(38, input.lastIndexOf('>')+1);
    body = body.substring(body.indexOf('<'));
    return header+"\n"+body+"\n";

}