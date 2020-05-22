class classRoom {
    Chair chair;
    Table table;
    Board board;
    String name;

    add_chair();
    add_table();
    remove_table();

}

class Chair {
    Leg leg1;
    Leg leg2;
}

class Leg {
    int height;
    set_height();
    get_height();
}

class Board {
    int width;
    int height;
}