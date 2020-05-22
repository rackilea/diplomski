String hex = "#ffffff00";

//-16711681 in ARGB int, for example used in Google's zxing library for colored qrcodes
System.out.println(toARGB(hex));

public static int toARGB(String nm) {
Long intval = Long.decode(nm);
long i = intval.intValue();

int a = (int) ((i >> 24) & 0xFF);
int r = (int) ((i >> 16) & 0xFF);
int g = (int) ((i >> 8) & 0xFF);
int b = (int) (i & 0xFF);

return ((a & 0xFF) << 24) |
        ((b & 0xFF) << 16) |
        ((g & 0xFF) << 8)  |
        ((r & 0xFF) << 0);
}