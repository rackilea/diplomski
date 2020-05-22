for(Iterator<Map.Entry<String, Entity>> iterator = entities.entrySet().iterator(); iterator.hasNext(); ){
    Map.Entry<String, Entity> entry = iterator.next();
    String key = entry.getKey();
    Entity item = entry.getValue();
    if (item.isDestroyed()){
        //Notice using an iterator to remove 
        iterator.remove();
        ViewManager.getInstance().removeItem(key);
        //INSTRUCT THE ENTITY TO PERFORM IT'S DESTROYED BEHAVIOR item.Destroyed()                    
    } else {
        item.update(1);
        ConsoleItem ci = new ConsoleItemImpl(item.getIdentifier(), item.getLocation(), ColorStringConverter.getInstance().StringToColor(item.getSide()), item.getAngle(), item.getShape(), item.toString(), item.isDestroyed(), item.isDamaged());
        ViewManager.getInstance().updateItem(ci);                    
    }

    item.update(1);

}