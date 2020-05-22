@EventHandler
public void playerKillsPlayer(EntityDeathEvent e) {
    Entity dead = e.getEntity();
    Entity killer = e.getEntity().getKiller();

    if(killer instanceof Player && dead instanceof Player){
        String killerUUID = ((Player) killer).getUniqueId().toString();
        String deadUUID = ((Player) dead).getUniqueId().toString();

        int kills = kdc.getConfig().getInt("playerkills." + killerUUID);
        int deaths = kdc.getConfig().getInt("playerdeaths." + deadUUID);
        kdc.getConfig().set("playerkills." + killerUUID + , kills += 1);
        kdc.getConfig().set("playerdeaths." + deadUUID, deaths += 1);


        killer.sendMessage("You now have " + kills + " kills!");
        dead.sendMessage("You now have " + deaths + " deaths!");
    }
}