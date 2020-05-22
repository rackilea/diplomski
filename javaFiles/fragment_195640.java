public static void main(String[] args) { 

        System.out.println(getString());
    }

     public static String getString() {
            return "sdsDsfsWerGDLKSAsdfsdfSAA".replaceAll(
                      String.format("%s|%s|%s",
                         "(?<=[A-Z])(?=[a-z])",
                         "(?<=[^A-Z])(?=[A-Z])",
                         "(?<=[A-Za-z])(?=[^A-Za-z])"
                      ),
                      " "
                   ).toLowerCase();
                }