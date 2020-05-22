public static <E extends Enum<E>> void writeEnum(String fileName, Class<E> c, SnelPlugin plugin){
    SnelTextFile file = new SnelTextFile(plugin, new File(plugin.getDataFolder() + "/" + fileName + ".txt"));
    Logger.debug("Starting EnumWriter for " + file.getFile().getName(), plugin);

    try {
        file.openWriter(true);
        Logger.debug("Opened FileWriter", plugin);

        Field[] classFields = c.getDeclaredFields();

        String header = "Value";

        for(Field f: classFields){
            if(!Modifier.isStatic(f.getModifiers())) {
                header += ", " + f.getName();
                Logger.debug("Discovered variable '" + f.getName() + "'", plugin);
            }
        }

        file.addLine(header);
        file.addLine("");

        for(E en: c.getEnumConstants()){
            Logger.debug("Reading Enum Constant: " + en.toString(), plugin);
            Field[] fields = en.getDeclaringClass().getDeclaredFields();

            String current = en.toString();

            for(Field f: fields){
                if(!Modifier.isStatic(f.getModifiers())){
                    f.setAccessible(true);
                    current += ", " + f.get(en);
                    Logger.debug("Value for '" +f.getName() + "' = '" +  f.get(en) + "'" , plugin);
                }
            }

            file.addLine(current);
        }
    }catch (Exception ex){
        ex.printStackTrace();
    }finally {
        try {
            file.closeWriter();
            Logger.debug("Closer FileWriter");
        } catch (IOException ex) {
        }
    }

    Logger.log(LColor.GREEN + "Finished EnumWriter for " + file.getFile().getName() + ". It can be found at " + file.getFile().getPath(), plugin);
}