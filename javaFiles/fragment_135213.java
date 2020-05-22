public void monsterFight(Player p, ArrayList<Room> roomList){
    if (p.getCurrentRoom().equals(roomList.get(1))) {
       // your monster has to fight a player!
       fightMonsters(snakeObject, p);

       // option B is to directly call:
       // snakeObject.fight(p, p.getInventory());
       // with the assumption on getInventory() defined later
    }
}