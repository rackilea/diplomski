public static String[][] splitStringArray(String[] input, int pos) {
        final int len = input.length;
        final String[][] result = new String[2][Math.max(pos, len - pos - 1)];
        result[0] = Arrays.copyOf(input, pos);
        result[1] = Arrays.copyOfRange(input, pos + 1, len);
        return result;
    }