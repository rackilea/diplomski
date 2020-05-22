public static void main(String[] args) throws IOException {

        String input = "[\"user1\",\"track1\",\"player1\", \"user1\",\"track2\",\"player2\", \"user1\",\"track3\",\"player3\"]";
        input = input.substring(1, input.length() - 1); // get rid of brackets
        String[] split = input.split(" ");

        FileWriter writer = new FileWriter("/Users/artur/tmp/csv/sto1.csv");

        for(String s : split) {
            String[] split2 = s.split(",");
            writer.write(Arrays.asList(split2).stream().collect(Collectors.joining(",")));
            writer.write("\n"); // newline
        }

        writer.close();

    }