private <T extends Component> void addNewComponentInstance(Class<T> type, int uid){
    try {
        getParent().getComponentManager().add(type, uid, type.newInstance());
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}