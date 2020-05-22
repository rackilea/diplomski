List<String> outputList = new ArrayList<String>();
while (loop) {
   if (bytesMessage instanceof BytesMessage) {
      BytesMessage msgResponse = (BytesMessage) bytesMessage;
      if (msgResponse.getBodyLength() == 0) {
         loop = false;
      } else {
         byte[] bytes = new byte[(int) msgResponse.getBodyLength()];
         msgResponse.readBytes(bytes);
         outputList.add(new String(bytes));
         msgResponse.acknowledge();
      }
   }
}