...

if(session.isNew()){
    ArrayList<> logList2 = new ArrayList<>();
    session.setAttribute(“logList”, logList2);
}

...

ArrayList<> actionJournal = (ArrayList<>)session.getAttribute(“logList”);
if(val == 1){
    list1.add(0, “yo yo yo”);
}
if(val == 2){
    list2.add(0, “ha ha ha”);
}