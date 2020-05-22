public void addTreeModelListener(TreeModelListener listener) 
{
    listenerList.add(TreeModelListener.class, listener);
}

public <T extends EventListener> T[] getListeners(Class<T> listenerType)
{
    return listenerList.getListeners(listenerType);
}