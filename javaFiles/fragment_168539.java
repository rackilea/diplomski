Class Data {
    HistoryListClass HistoryList;
    Relation related;
}

Class HistoryListClass {
    List<History> history;
}

Class History {
    String comment;
    String create;
    int ID;
    String ttURL;
}

Class Relation {
    String book;
    String ID;
}