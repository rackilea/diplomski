else {
                for (int i = 1; i < str.length() - 2; i++) {
                    if (str.substring(i, i + 3).equals("xyz") && !str.substring(i - 1, i).equals(".")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }