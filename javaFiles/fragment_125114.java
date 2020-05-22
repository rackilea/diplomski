catch (Exception e) {
    pw.write(new Date().toString()); // Adding the date
    pw.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); // Formatted date
    e.printStackTrace(pw);
    pw.flush();
}