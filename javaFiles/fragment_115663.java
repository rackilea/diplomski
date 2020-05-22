public List<Note> getList(){
    List<Note> detachedList=null, list=null;
    try {
        String query = "select from " + Note.class.getName();
        pm = PMF.get().getPersistenceManager();
        list = (List<Note>)pm.newQuery(query).execute();            
        detachedList = new ArrayList<Note>();
        for(Note obj : list){
            detachedList.add(pm.detachCopy(obj));
        }

    } finally {
        pm.close();
    }
    return detachedList;

}