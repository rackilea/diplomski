while ((checkIfPlayer = bReader.readLine()) != null) {
    // Arraylist
    String temp = checkIfPlayer.trim();
    System.out.println(temp);
    if (temp.contains("ZOMBIE") || temp.contains("HUMAN")) {
        String[] getName = temp.split(" ");
        String checkName = getName[2];
        boolean added = false;
        for(int i = 0; i < player_status_list.size(); i++) {
            if(player_status_list.get(i).contains(checkName)) {
                player_status_list.set(i, temp);
                added = true;
            }
        }
        if(!added) {
            player_status_list.add(temp);
        }
        DrawTheMap();
    }
}