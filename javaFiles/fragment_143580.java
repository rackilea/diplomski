public int firstUniqChar(String s) {
    int count[] = new int[122 - 96];
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        count[chars[i] - 97]++;
    }
    for (int i = 0; i < chars.length; i++) {
        if (count[chars[i] - 97] == 1)
            return i;
    }
    return -1;
}