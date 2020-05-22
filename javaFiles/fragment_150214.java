Iterator<ConfigItem> it = configItems.iterator();
while(it.hasNext()){
    ConfigItem c = it.next();
    if (c.ITEM.equals(item))
    {
        it.remove();
        break;
    }
}