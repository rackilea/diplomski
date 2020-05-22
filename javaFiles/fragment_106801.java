public static void main(final String[] args) {

        final String input = args[0];

        final String[] tokens = input.split(",");

        for (int i = 0 ; i < tokens.length ; i++) {
            for (int j = i + 1 ; j < tokens.length ; j++) {
                String left = tokens[i];
                String right = tokens[j];
                if (isNumber(left) && isNumber(right)) {
                    int lNum = Integer.valueOf(left);
                    int rNum = Integer.valueOf(right);
                    if (lNum < rNum) {
                        swap(tokens, i, j);
                    }
                }
            }
        }

     }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static void swap(final String[] arr, int i, int j) {
        final String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }