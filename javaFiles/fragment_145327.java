String prefix(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str.toCharArray()[i];
        }
        return result;
}