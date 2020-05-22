public String camelCase(String str) {
        if (str == null ||str.trim().length() == 0) return str;
        String[] split = str.split("_");
        String newStr = split[0];
        for (int i = 1; i < split.length; i++) {
            newStr += split[i].substring(0, 1).toUpperCase() +  split[i].substring(1);
        }
        return newStr;
    }