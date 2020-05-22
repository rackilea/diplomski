public static String multiply(String binary1, String binary2) {
        try {
            binary1 = binary1.substring(binary1.indexOf('1'));
            binary2 = binary2.substring(binary2.indexOf('1'));
        } catch (StringIndexOutOfBoundsException e) {// some number is 0
            return "0";
        }

        // 1st step: multiply each bit of binary2 by binary1
        String zero = IntStream.range(0, binary1.length()).mapToObj(v -> "0").collect(Collectors.joining());
        StringBuilder lpad = new StringBuilder(IntStream.range(0, binary2.length() - 1).mapToObj(v -> "0").collect(Collectors.joining()));
        StringBuilder rpad = new StringBuilder();
        String[] prod = new String[binary2.length()];

        for (int i = binary2.length() - 1, j = 0; i >= 0; i--, j++) {
            prod[j] = lpad.toString()
                    .concat(binary2.charAt(i) == '1' ? binary1 : zero)
                    .concat(rpad.toString());
            if (lpad.length() > 0) {
                lpad.deleteCharAt(0);
                rpad.append('0');
            }
        }

        // 2nd step: sum the products
        String result = prod[0];

        for (int i = 1; i < prod.length; i++) {
            StringBuilder sum = new StringBuilder();
            int[] carry = new int[binary1.length() + binary2.length()];

            for (int j = binary2.length() + binary1.length() - 2; j >= 0; j--) {
                int r = result.charAt(j) - '0' + prod[i].charAt(j) - '0';

                if (r > 1) {
                    sum.append(carry[j + 1]);
                    carry[j] = 1;
                } else if ((r += carry[j + 1]) > 1) {
                    sum.append('0');
                    carry[j] = 1;
                } else {
                    sum.append(r);
                }
            }

            if (carry[0] == 1) {
                sum.append('1');
            }

            result = sum.reverse().toString();
        }

        return result;
    }