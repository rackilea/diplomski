public static void main(String[] args) {

    String texts[] = {"Image pixel 200x500 px blur",
        "Image pixel 200 x 500 blurring",
        "100.22 x 200.55 x 90.55 mm is the size of the handphone",
        "The mobile phone is 100.22x200.55x90.55 mm in dimension"};

    String regex = "((?:\\d[\\d\\s\\.x]+\\d)(?:\\s*(?:px|mm))?)";

    Pattern p = Pattern.compile(regex);

    for (int q = 0; q < texts.length; q++){
        Matcher m = p.matcher(texts[q]);
        while (m.find()){
            System.out.println(m.group());
        } 
    }
}