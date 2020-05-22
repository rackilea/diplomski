for(int i=0; i<jsonArray.size(); i++){
    Map activityobject  = ((Map)jsonArray.get(i));
    System.out.println(activityobject);
    if (activityobject.containsKey("action")) {
        Map actionObject  = ((Map)activityobject.get("action"));
        if (actionObject.containsKey("note")) {
            System.out.println("its a note");
            System.out.println("note" + actionObject.get("note"));
            System.out.println("Performed at " + activityobject.get("performed_at"));
        }
    }
}