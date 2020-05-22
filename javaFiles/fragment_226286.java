final String[] input = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight" };
        final int len = input.length;
        final int pos = 3;
        final String[][] result = new String[2][Math.max(pos, len - pos - 1)];
        result[0] = Arrays.copyOf(input, pos);
        result[1] = Arrays.copyOfRange(input, pos + 1, len);