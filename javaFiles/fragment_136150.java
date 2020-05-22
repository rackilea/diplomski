@SuppressWarnings("unchecked")
private JList<Class<?>> findFileList(Component comp){
    if (comp instanceof JList){
        return (JList<Class<?>>) comp;
    }
    if (comp instanceof Container){
        for (Component c : ((Container) comp).getComponents()){
            JList<Class<?>> list = findFileList(c);
            if (list != null){
                return list;
            }
        }
    }
    return null;
}