Scarface Embroidered Leather




//Sca???rfa???ce??? E???mbr???oi�d???ered L�e???athe
//Scarface Embroidered Leathe

String hex="5363613f3f3f7266613f3f3f63653f3f3f20453f3f3f6d62723f3f3f6f69‌​643f3f3f65726564204c‌​653f3f3f61746865";
byte[] bytes= hexStringToBytes(hex);

//the only line you need
String res = new String(bytes,"UTF-8").replaceAll("\\\u003f","").replaceAll('�',"").replaceAll("�","");

private static byte charToByte(char c) {
    return (byte) "0123456789ABCDEF".indexOf(new String(c));
}


public static byte[] hexStringToBytes(String hexString) {
    if (hexString == null || hexString.equals("")) {
        return null;
    }
    hexString = hexString.toUpperCase();
    int length = hexString.length() / 2;
    char[] hexChars = hexString.toCharArray();
    byte[] d = new byte[length];
    for (int i = 0; i < length; i++) {
        int pos = i * 2;
        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

    }
    return d;
}

public static String bytesToHexString(byte[] src){
    StringBuilder stringBuilder = new StringBuilder("");
    if (src == null || src.length <= 0) {
        return null;
    }
    for (int i = 0; i < src.length; i++) {
        int v = src[i] & 0xFF;
        String hv = Integer.toHexString(v);
        if (hv.length() < 2) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hv);
    }
    return stringBuilder.toString();
}

public   String printHexString( byte[] b) {
    String a = "";
    for (int i = 0; i < b.length; i++) { 
        String hex = Integer.toHexString(b[i] & 0xFF); 
        if (hex.length() == 1) { 
            hex = '0' + hex; 
        }

        a = a+hex;
    } 

    return a;
}