int sum = 0;
            Boolean isValidCard = true;
            for (int i = 0; i < num.length(); i++) {
                ch1 = num.charAt(i);
                if (Character.isDigit(ch1)) {
                    if (i % 2 == 1) {
                        sum += ((int) ch1 - 48);
                    } else {
                        int temp = (2 * ((int) ch1 - 48));
                        while (temp > 0) {
                            sum += temp % 10;
                            temp = temp / 10;
                        }
                    }
                } else {
                    isValidCard = false;
                    break;
                }
            }
            if (!isValidCard) {
                System.out.println("CC Invalid");
            } else if (sum % 10 == 0) {
                System.out.println("CC is valid");
            }