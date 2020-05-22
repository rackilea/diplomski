# MyInputFormat.java

public static void setEnvironmnet(
    Job job, 
    String host, 
    String port, 
    boolean ssl, 
    String APIKey) {

    backend = new Backend(host, port, ssl, APIKey);
}