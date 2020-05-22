public void deletePlayerFromTeam(int idPlayer){
    Player player = //loadPlayer;
    player.setTeam(null);

    playerRepository.save(player);
}