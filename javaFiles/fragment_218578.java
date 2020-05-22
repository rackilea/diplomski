public static void main(String[] args) throws Exception {

    Pattern pattern = Pattern.compile("[A-G]+[A-G]{0,1}");
    Pattern pattern2 = Pattern.compile("[V]+[V]*");

    BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")));
    String line;
    while ((line = br.readLine()) != null) {
        StringBuffer sf = new StringBuffer();

        //System.out.println(line);         
        String[] tempArr = line.split(" ");
        //System.out.println(tempArr.length);

        for(String s : tempArr){
            Matcher matcher = pattern.matcher(s);
            Matcher matcher2 = pattern2.matcher(s);
            if (matcher.find()) {
                sf.append("R");
            }else if(matcher2.find())   {
                sf.append(" ");
            }
        }
        System.out.println(sf);
    }
    br.close();
}