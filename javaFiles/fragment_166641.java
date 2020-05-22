try {
    sqlCall();
} catch (SQLExcetion e) {
    sendMail();

    throw e;
}