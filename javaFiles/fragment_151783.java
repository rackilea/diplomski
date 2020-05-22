catch (Exception e) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    e.printStackTrace(pw);
    pw.flush();
    String stackTrace = sw.toString();
    // do whatever you want to do with stackTrace
}