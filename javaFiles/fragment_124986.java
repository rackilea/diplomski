private String convertToMyJSON(Logs logs) {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    String jsonObject = "{"
            + "\"executionId\":\"" + logs.getExecutionId() + "\","
            + "\"startDate\":\"" + sdf.format(logs.getStartDate()) + "\","
            + "\"logList\":[" + getLogString(logs) + "]"
            + "}";

    return jsonObject;
}

private String getLogString(Logs logs) {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    String logString = "";

    for (Log l : logs.getLogList()) {

        logString = logString
                + "{"
                + "\"id\":" + l.getId() + ","
                + "\"executionId\":\"" + logs.getExecutionId() + "\","
                + "\"startDate\":\"" + sdf.format(l.getStartDate()) + "\","
                + "\"endDate\":\"" + sdf.format(l.getEndDate()) + "\","
                + "},";
    }

    return logString.substring(0, logString.lastIndexOf(","));
}