public static int toLittleEndian(final String hex) {
    int ret = 0;
    String hexLittleEndian = "";
    if (hex.length() % 2 != 0) return ret;
    for (int i = hex.length() - 2; i >= 0; i -= 2) {
        hexLittleEndian += hex.substring(i, i + 2);
    }
    ret = Integer.parseInt(hexLittleEndian, 16);
    return ret;
}

Input: FC5F2E00
Output: 3039228