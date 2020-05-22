public static String finalResult(String result[]) {
        StringBuilder final_result = new StringBuilder();
        String[] betweenZeroAnd50 = new String[] { "E", "S", "T", "J" }; 
        String[] greatherThan50 = new String[] { "I", "N", "F", "P" };
        if (result.length == 4) {
            //instead of writing 3 times if with same condition and only index changes so avoid repeatly code and use loop.
            for (int i = 0; i < 4; i++) {
                if (result[i].contains("NO ANSWERS")) {
                    final_result.append("-");
                } else if (isNumeric(result[i]) && Integer.parseInt(result[i]) >= 0
                        && Integer.parseInt(result[0]) < 50) {
                    final_result.append(betweenZeroAnd50[i]);
                } else if (isNumeric(result[i]) && Integer.parseInt(result[i]) > 50) {
                    final_result.append(greatherThan50[i]);
                } else {
                    final_result.append("X");
                }
            }
        }
        return final_result.toString();
    }

 public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }