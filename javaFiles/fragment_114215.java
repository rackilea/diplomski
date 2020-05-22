//@RequestParam data

//remove mimeType declaration in the data string first

String byteStr = data.split(",")[1];


//get the byte array of the data

byte[] bytes = Base64.decodeBase64(byteStr);