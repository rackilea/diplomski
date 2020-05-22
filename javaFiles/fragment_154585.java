public static void main(String[] args) throws Exception {
    String x = "M|N| | |\"DANGER| AWESOME\"|N|N| | | |";
    String regex = "\\|(?=([^\"]*\"[^\"]*\")*[^\"]*$)"; 
    String[] y = x.split(regex);
    for(String s : y) {
        System.out.println(s);
    }
    System.out.println("************* DONE ***********");
}