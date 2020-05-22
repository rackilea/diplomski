public static void main(String[] args) {
        String line = "SVR GAME MOVE {PLAYER: \"player2\", MOVE: \"26\",DETAILS: \"\"}";
        Pattern pat = Pattern.compile(".*MOVE: *\"([0-9]+).*");
        Matcher mat = pat.matcher(line);
        if(mat.matches()) {
            String move = mat.group(1);
            System.out.println(move);
        }
    }