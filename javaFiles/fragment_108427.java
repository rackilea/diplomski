int ch;
StringBuilder text = new StringBuilder();
while((ch = serverConnection.getInputStream().read())!= -1) { // -1 will be read at EOS
    text.append((char)ch);
}
sentData = text.toString();
return true;