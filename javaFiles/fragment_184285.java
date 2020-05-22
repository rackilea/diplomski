while ((ss = br.readLine()) != null) {
    String[] sv = ss.split(" ");


        player_name.add(sv[1]);
        player_score.add(Integer.parseInt(sv[2]));


}


bubble_srt(player_score);