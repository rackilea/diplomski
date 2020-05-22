// I'd still declare `item` as late as possible, i.e. here rather than
// outside the `try` block, unless you *also* need it outside the try block...
Item item;
if (rs.getString("type").equals("weapon")) { 
    Weapon weapon = new Weapon();
    weapon.setDamage();
    item = weapon;
} else {
    Armor armor = new Armor();
    armor.setDefense();
    item = armor;
}
// Other code using `item` here