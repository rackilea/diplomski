switch (Integer.parseInt(token2)) {
    case 0:
        player.setRights(PlayerRights.PLAYER);
        break;
    case 1:
        player.setRights(PlayerRights.MODERATOR);
        break;
    case 2:
        player.setRights(PlayerRights.ADMINISTRATOR);
        break;
    case 3:
        player.setRights(PlayerRights.DEVELOPER);
        break;
    case 4:
        player.setRights(PlayerRights.DONATOR);
        break;
}