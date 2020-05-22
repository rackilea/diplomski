@Override
public List<AbstractItem> onAdd(List<AbstractItem> list)    {
    for (AbstractItem item : list)      {
        if (item.shoudBeRemovedBecauseType1(this))          {
            list.remove(item);
            break;
        }
    }
    return list;
}