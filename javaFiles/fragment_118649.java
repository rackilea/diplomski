String data = null;
StringBuffer dataBuffer = new StringBuffer();
while ((data = stdInput.readLine()) != null) {
    logger.info("Data:"+data);
    dataBuffer.append(data).append("\n");
}
String completeData = dataBuffer.toString();