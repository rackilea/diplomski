static char getRandomChar(String s){//pass string "AHFGD" here
    Random random = new Random();
    int index = random.nextInt(s.length());
    return s.charAt(index);

}