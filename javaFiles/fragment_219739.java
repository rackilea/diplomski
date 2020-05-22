try {
    // some code
} catch (Exception e) {
    StringBuilder sb = new StringBuilder(e.toString());
    for (StackTraceElement ste : e.getStackTrace()) {
        sb.append("\n\tat ");
        sb.append(ste);
    }
    String trace = sb.toString();
    // Now, trace contains the stack trace
    // (However, you can only use it inside the catch block)
}