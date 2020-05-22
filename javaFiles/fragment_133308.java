Map<String, List<String>> headers = connection.getHeaderFields();
for (Entry<String, List<String>> header : headers.entrySet()) {
if(header.getKey().equals("Content-Legth")){
len=Integer.parseInt(header.getValue());
}
}