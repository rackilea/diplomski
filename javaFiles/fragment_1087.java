public class MyLogFilter implements LogFilter {
    public boolean isLoggable(LogRecord record) {
    if (SessionUtil.getSessionId() != null && 
            !SessionUtil.getSessionId().toString().equals("")) {
        StringBuilder sessId = new StringBuilder(SessionUtil.getSessionId().toString());
        String methodName = record.getSourceMethodName();
            if (methodName != null && !methodName.equals("")) {
            if (!methodName.endsWith(sessId.toString())) {
                    record.setSourceMethodName(sessId.insert(0, " ").insert(0, methodName).toString());
            }
            } else {
            record.setSourceMethodName(sessId.toString());
            }
    }
        return true;
    }
}