public void handleSuccess(String result) {
    result = result.trim();
    log.info("Result after trimming: '" + result + "'");

    result = result.substring(result.indexOf('\n') + 1);
    log.info("Result after substring: '" + result + "'");

    String returns = getReturns();
    log.info("Returns: '" + returns + "'");

    String action = getAction();
    log.info("Action: '" + action + "'");

    // It's not clear what this is meant to do. I suggest you remove it and
    // use logging instead.
    MessageBox.alert("Information", "The selected action is " + action, null);             

    String finalResult = result + returns + action;
    log.info("Final result: '" + finalResult + "'");