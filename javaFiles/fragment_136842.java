public void service(ServletRequest req, ServletResponse res) {
    final JSONArray arr=new JSONArray();
    for (String s : this.myListOfStrings){
        arr.put(s);
    }
    //Here we serialize the stream to a String.
    final String output = arr.toString();
    res.setContentLength(output.length());
    //And write the string to output.
    res.getOutputStream().write(output.getBytes());
    res.getOutputStream().flush();
    res.getOutputStream().close();
}