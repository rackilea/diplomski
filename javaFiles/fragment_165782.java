public Player findFirstAttacker(Collection<Player> players) {
  for (Player p : players) {
    if (p.getPositionType() == Player.POSITION_ATTACKER) {
      return p;
    }
  }

  return null;
}