int counter = 0;
    public void instantiate() {
            item[1] = new agendaitem();
            item[2] = new agendaitem();
            item[3] = new agendaitem();
    }
    public void createobject(String name, Boolean complete, String Comments) {
        item[counter].name = name;
        item[counter].complete = complete;
        item[counter].comments = Comments;
        counter++;
    }