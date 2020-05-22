public static void main(String[] args) {
        String input = "this is a Sample text";
        String[] tokens = input.split("\\s+");
        StringBuilder output = new StringBuilder();
        for (String s : tokens) {
            output.append(s.trim().replaceFirst(String.valueOf(s.charAt(0)),
                    String.valueOf(Character.toUpperCase(s.charAt(0)))));
        }

        System.out.println(output.toString());//ThisIsASampleText
    }