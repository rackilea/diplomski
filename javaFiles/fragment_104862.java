@RequestMapping(method = RequestMethod.POST, value = "/payments/confirm")
public void receiveCallback(HttpServletRequest request) {
    try {
        StringBuilder sb = new StringBuilder();
        sb.append("Headers:\n");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headers = request.getHeaders(headerName);
            while (headers.hasMoreElements()) {
                String headerValue = headers.nextElement();
                sb.append(headerName).append(':').append(headerValue).append('\n');
            }
        }
        sb.append("\nParameters:\n");
        for(Entry entry: (Set<Entry>) request.getParameterMap().entrySet(){
            sb.append(entry.getKey()).append(':').append(entry.getValue()).append('\n');
        }
        byte[] data = sb.toString().getBytes();

        File file = new File(System.getProperty("java.io.tmpdir") + "test"
                + System.currentTimeMillis() + ".txt");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
    } catch (Exception e) {
        logger.error("Error writing request", e);
    }
}