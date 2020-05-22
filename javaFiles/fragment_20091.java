UUID uuid = player.getUniqueId();

ItemStack[] contents = items.get(uuid);
ItemStack[] armorContents = armor.get(uuid);

player.getInventory().setContents(contents);
player.getInventory().setArmorContents(armorContents);