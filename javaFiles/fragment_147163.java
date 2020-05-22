public SpecialPlayer(Player player) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
    super(player.money); //Still need to do this
    for(Field sfield:player.getClass().getDeclaredFields();){
        sfield.setAccessible(true);
        sfield.set(this, sfield.get(player));
    }
}