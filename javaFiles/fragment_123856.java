public YamlConfiguration yc;
//...
public void loadData()
{
    if (cf.exists())
        yc = YamlConfiguration.loadConfiguration(cf);
    else
        yc = YamlConfiguration.loadConfiguration(getResource("economy.yml"));
}