public String hexStringtoByteArray(String str) { 
    byte[] bytes = new byte[str.length() / 2]; 
    for (int i = 0; i < bytes.length; i++) { 
        bytes[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2), 16); 
    } 
    return new String(bytes, "UTF-8"); 
}