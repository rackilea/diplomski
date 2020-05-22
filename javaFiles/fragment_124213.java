if (rs.getString("type").equals("weapon")) { 
    Weapon weapon = new Weapon();
    weapon.setDamage();
    return weapon;
} else {
    Armor armor = new Armor();
    armor.setDefense();
    return armor;
}