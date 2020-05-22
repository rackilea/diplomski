public static String starMinusLine(int stars, int minuses) {
        StringBuilder sb = new StringBuilder();

        if (minuses == 1) {
            for (int j = 0; j < stars; ++j) {
                sb.append("*");
            }
            for (int i = 0; i < (minuses); ++i) {
                sb.append("-");
            }
        }

        if (minuses % 2 == 0) {
            for (int i = 0; i < (minuses * 0.5); ++i) {
                sb.append("-");
            }
            for (int j = 0; j < stars; ++j) {
                sb.append("*");
            }
            for (int k = 0; k < (minuses * 0.5); ++k) {
                sb.append("-");
            }
        }
        if (minuses % 2 == 1 && minuses != 1) {
            for (int i = 0; i < ((minuses * 0.5) - 0.5); ++i) {
                sb.append("-");
            }
            for (int j = 0; j < stars; ++j) {
                sb.append("*");
            }
            for (int k = 0; k < ((minuses * 0.5)); ++k) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}