public static void main(String[] args) throws Exception {
    System.out.println(removeDuplicates("miamimiamimiami"));
    System.out.println(removeDuplicatesRegex("miamimiamimiami"));
}

public static String removeDuplicates(String input){
    StringBuilder data = new StringBuilder(input);
    for (int i = 0; i < data.length(); i++) {
        String character = String.valueOf(data.charAt(i));
        int dupIndex = data.indexOf(character, i + 1);
        while (dupIndex != -1) {
            data.deleteCharAt(dupIndex);
            dupIndex = data.indexOf(character, i + 1);
        }
    }

    return data.toString();
}

public static String removeDuplicatesRegex(String input) {

    return new StringBuilder(
            new StringBuilder(input)
                    .reverse()
                    .toString()
                    .replaceAll("(.)(?=.*\\1)", ""))
            .reverse().toString();
}