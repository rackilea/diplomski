Map<UUID, ItemStack[]> items = new HashMap<UUID, ItemStack[]>();
Map<UUID, ItemStack[]> armor = new HashMap<UUID, ItemStack[]>();

public void storeAndClearInventory(Player player){
    UUID uuid = player.getUniqueId();

    ItemStack[] contents = player.getInventory().getContents();
    ItemStack[] armorContents = player.getInventory().getArmorContents();

    items.put(uuid, contents);
    armor.put(uuid, armorContents);

    player.getInventory().clear();

    player.getInventory().setHelmet(null);
    player.getInventory().setChestplate(null);
    player.getInventory().setLeggings(null);
    player.getInventory().setBoots(null);
}

public void restoreInventory(Player player){
    UUID uuid = player.getUniqueId();

    ItemStack[] contents = items.get(uuid);
    ItemStack[] armorContents = armor.get(uuid);

    if(contents != null){
        player.getInventory().setContents(contents);
    }
    else{//if the player has no inventory contents, clear their inventory
        player.getInventory().clear();
    }

    if(armorContents != null){
        player.getInventory().setArmorContents(armorContents);
    }
    else{//if the player has no armor, set the armor to null
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
    }
}