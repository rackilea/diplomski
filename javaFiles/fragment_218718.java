public static Section getSectionByTitle(String title, Key user_key){
    PersistenceManager pm = PMF.get().getPersistenceManager();  
    Query query = pm.newQuery("select from "+Section.class.getName()+" WHERE title == s && user == keyParam");
    query.declareParameters("String s, String k");
    query.setUnique(true);
    Section section = (Section) query.execute(title, user_key.getId());
    return section;
}