for(Iterator<Player> i = waiting.iterator(); i.hasNext();) {
    Player p = i.next(); 
    if(!boat.playerInArea(p)) {
        i.remove(); // Allowed with an iterator
    }
}