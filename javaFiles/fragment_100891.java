String string = "Orange juice is great! I drank 83,214 cups of it yesterday.";
String[] numbers = {"Ze", "On", "Tw", "Th", "Fo", "Fi", "Si", "Se", "Ei", "Ni"};
String result = "";
for (char c : string.toCharArray()) {
    if (c >= 48 && c <= 57) {// range [0-9] digits
        result += numbers[c - 48];
    } else if (c >= 97 & c <= 122) {// range [a-z] lower letters
        result += String.format("%02d", (char) c - 96);
    } else if (c >= 65 & c <= 90) {// range [A-Z] upper letters
        result += c - 38;
    }else {
        result += c;
    }
}

System.out.println(result);