//temp = "4711 PLAYER joseph HUMAN 30.1 30.1";
//checkName = "joseph"

//This is checking if the list contains:  "joseph"
if (!player_status_list.contains(checkName)) {
    //If it doesn't have it we are adding: "4711 PLAYER joseph HUMAN 30.1 30.1";
    //This doesn't seem right!!!
    player_status_list.add(temp);

   //This will never happen because list is always adding the temp variable not the name
} else if (player_status_list.contains(checkName)) {
    for (int i = 0; i < player_status_list.size(); i++) {
        player_status_list.set(i, temp);
    }
}