public static void main(String[] args) {
    String s = "player.login name=username;x=52;y=406";
    String[] expressions = s.split(";");
    for (String exp : expressions) {
        System.out.println(exp.split("=")[1]);
    }
}