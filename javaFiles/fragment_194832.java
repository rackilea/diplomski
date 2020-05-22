private boolean friend, workmate, neighbour, fan;

public void showPopup(View v) {
    Context wrapper = new ContextThemeWrapper(this, R.style.PopupPerfilAjeno);
    PopupMenu popup = new PopupMenu(wrapper, v);
    popup.setOnMenuItemClickListener(this);
    popup.inflate(R.menu.menu);

    Menu menuOpts = popup.getMenu();

    if (friend) {
        menuOpts.getItem(0).setTitle(R.string.remove_friends);
    }
    if (workmate) {
        menuOpts.getItem(1).setTitle(R.string.remove_workamtes);
    }
    if (neighbour) {
        menuOpts.getItem(2).setTitle(R.string.remove_neighbours);
    }
    if (fan) {
        menuOpts.getItem(3).setTitle(R.string.remove_fans);
    }

    popup.show();
}

private void addContact(final int circle) {

    switch (circle) {
        case 1:
             friend = true;
             workmate = false;
             neighbour = false;
             fan = false;
             break;
        case 2:
             friend = false;
             workmate = true;
             neighbour = false;
             fan = false;
             break;
        case 3:
             friend = false;
             workmate = false;
             neighbour = true;
             fan = false;
             break;
        case 4:
             friend = false;
             workmate = false;
             neighbour = false;
             fan = true;
             break;
     }
 }