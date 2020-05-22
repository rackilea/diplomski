StringBuilder builder = new StringBuilder();
BufferedReader reader = new BufferedReader(new FileReader(new File("resources/json1.txt")));
String line = null;
while ((line = reader.readLine()) != null) {
    builder.append(line);
}
reader.close();

Gson gson = new Gson();
Type listType = new TypeToken<ArrayList<MyJSON>>() {
}.getType();
List<MyJSON> list = gson.fromJson(builder.toString(), listType);
// you can try this form as well
// MyJSON[] list = gson.fromJson(builder.toString(), MyJSON[].class);

for (MyJSON json : list) {
    System.out.println(json.toString());
}

...

class MyJSON {
    String item_name;
    String item_type;
    String item;
    String item_min_lvl;
    Enchantment enchantment;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("\nitem_name:").append(item_name);
        builder.append("\nitem_type:").append(item_type);
        builder.append("\nitem:").append(item);
        builder.append("\nitem_min_lvl:").append(item_min_lvl);

        builder.append("\n\nEnchantment Details:");
        builder.append("\nhealth:").append(enchantment.health);
        builder.append("\ndam:").append(enchantment.dam);
        builder.append("\nlife:").append(enchantment.life);
        builder.append("\nxp:").append(enchantment.xp);
        builder.append("\nloot:").append(enchantment.loot);
        return builder.toString();
    }
}

class Enchantment {
    String health;
    String dam;
    String life;
    String xp;
    String loot;
}