UUID uuid = player.getUniqueId();

ItemStack[] contents = player.getInventory().getContents();
ItemStack[] armorContents = player.getInventory().getArmorContents();

items.put(uuid, contents);
armor.put(uuid, armorContents);