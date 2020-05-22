@WebMethod(operationName = "helloArray")
public String helloArray(@WebParam(name = "name") String[] name) {
    StringBuilder sb = new StringBuilder("Hello ");
    if (name != null) {
        for(int i = 0; i < name.length; i++) {
            sb.append(name[i]);
            if (i < (name.length - 1)) {
                sb.append(" and ");
            }
        }
    }
    sb.append('!');
    return sb.toString();
}