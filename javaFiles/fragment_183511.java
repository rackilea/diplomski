public static String getStringFromByteBuffer(ByteBuffer bb) { 
    StringBuilder message = new StringBuilder(); 
    int bytes;
    while(true) {
        try { 
            bytes = bb.get(); 
                // format the product of two bytes and a bitwise AND with 0xFF 
            message.append("\\x"+String.format("%02x", bytes&0xff)); 
        } catch (Exception e) { 
            break; 
        } 
    } 
    return message.toString(); 
}