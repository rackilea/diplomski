String message; //String that holds your message
String previewMessage = ""; //String to store your pewview message

if(message.length() >= 255) {
  previewMessage = message.substring(0, 254);
}