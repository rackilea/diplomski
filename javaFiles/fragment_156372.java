public static void main(String[] args) {
    String hex = "0x7B5C727466315C616E73695C616E7369637067313235325C6465" +
                 "6666305C6465666C616E67313033337B5C666F6E7474626C7B5C66" +
                 "305C666E696C5C666368617273657430204D6963726F736F667420" +
                 "53616E732053657269663B7D7D5C766965776B696E64345C756331" +
                 "5C706172645C66305C667331382068656C6C6F5C70617220207D";
    byte[] bytes = hexStringToByteArray(hex.substring(2));
    String text = new String(bytes, StandardCharsets.US_ASCII);
    System.out.println(text);
}
public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
    }
    return data;
}