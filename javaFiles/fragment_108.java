JsonValue json = new JsonReader().parse(text);
Array<Weapon> weapons = new Array<Weapon>();
JsonValue weaponsJson = json.get("weapons");
for (JsonValue weaponJson : weaponsJson.iterator()) // iterator() returns a list of children
{
    Weapon newWeapon = new Weapon();
    newWeapon.name = weaponJson.getString("name");
    newWeapon.price = weaponJson.getInt("price");
    weapons.add(newWeapon);
}