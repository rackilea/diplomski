@Override
public Info[] search(short length) {
    Info[] infolist = new Info[length];

    for (int i = 0; i < infolist.length; i++) {
        infolist[i] = new Info("New Name");
    }

    return infolist;
}