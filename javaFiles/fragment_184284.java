try {
    int i;
    String ss;
    FileReader fr;
    fr = new FileReader(new File("file.txt"));
    BufferedReader br = new BufferedReader(fr);
    int xy=0;
    List<String> player_name = new ArrayList<String>();
    List<Integer> player_score = new ArrayList<Integer>();


 while ((ss = br.readLine()) != null) {
    String[] sv = ss.split(" ");


        player_name.add(sv[1]);
        player_score.add(Integer.parseInt(sv[2]));


}


bubble_srt(player_score);


} catch (Exception e) {
}