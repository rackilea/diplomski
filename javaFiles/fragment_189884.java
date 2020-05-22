if (reload == 0) {
    String mailSuccess = "send success mail";
} else {
    String mailOther = "send other mail";
}

StringBuilder mailErrors = new StringBuilder();

if (fileError1Exists) {
    mailErrors.append("error 1 occurred");
}

if (fileError2Exists) {
    mailErrors.append("error 2 occurred");
}

if (fileError3Exists) {
    mailErrors.append("error 3 occurred");
}

String mailErrorText = mailErrors.toString();