if (localeFile == null) {
    File localeFile = new File(this.getDataFolder(), "locale.yml");
}
locale = YamlConfiguration.loadConfiguration(localeFile);

// Look for defaults in the jar
Reader localeStream = new InputStreamReader(this.getResource("locale.yml"));
if (localeStream != null) {
    YamlConfiguration loc = YamlConfiguration.loadConfiguration(localeStream);
    locale.setDefaults(loc);
}