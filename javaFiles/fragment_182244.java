//Setup the weapon classes
logger.info("Initializing the weapon classes.");
stat = conn.prepareStatement("SELECT *" + 
                            " FROM " + DB_NAME + ".weapons");

HashMap<String, Weapon> weapons = new HashMap<String, Weapon>();

rs = stat.executeQuery();
while (rs.next()) {
    Weapon weapon = new Weapon()
        .setId(rs.getint("weapon_id"))
        .setName(rs.getString("name"))
        .setDescription(rs.getString("description"))
        .setFilename(rs.getString("filename"))
        .setRarity(rs.getint("rarity"))
        .setSellPrice(rs.getint("sell_price"))
        .setQuantityMax(rs.getint("quantity_max"))
        .setSlot(rs.getint("slot"))
        .setLvlRequirement(rs.getint("level_requirement"))
        .setStrRequirement(rs.getint("strength_requirement"))
        .setDexRequirement(rs.getint("dexterity_requirement"))
        .setIntRequirement(rs.getint("intelligence_requirement"))
        .setEnchantedInc(rs.getint("enchanted_increase"))
        .setEnchantedCost(rs.getint("enchanted_cost"))
        .setHitMin(rs.getint("hit_min"))
        .setHitMax(rs.getint("hit_max"))
        .setSpeed(rs.getint("speed"))
        .setElementalType(rs.getint("elemental_type"))
        .setElementalHitMin(rs.getint("elemental_hit_min"))
        .setElementalHitMax(rs.getint("elemental_hit_max"));

    weapons.put(rs.getString("name"), weapon);
}