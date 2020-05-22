if (!player_status_list.contains(checkName)) {
    player_status_list.add(temp);
} else if (player_status_list.contains(checkName)) {
    for (int i = 0; i < player_status_list.size(); i++) {
        player_status_list.set(i, temp);
    }
}