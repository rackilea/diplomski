String originalString = "message_type=msgTyp&message_number=1&code=2&message=a&=b&timestamp=12";
String[] predefinedParameters = {"message_type", "message_number", "code", "message", "timestamp"};
String delimeter = "###";

for (String str : predefinedParameters) {
    originalString = originalString.replace(str+"=", delimeter+str+"=");
}

originalString = originalString.substring(delimeter.length());

String[] result = originalString.split("&"+delimeter);