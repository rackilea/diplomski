public   String getString() {
            return string.replaceAll(
                      String.format("%s|%s|%s",
                         "(?<=[A-Z])(?=[a-z])",
                         "(?<=[^A-Z])(?=[A-Z])",
                         "(?<=[A-Za-z])(?=[^A-Za-z])"
                      ),
                      " "
                   ).toLowerCase();
                }