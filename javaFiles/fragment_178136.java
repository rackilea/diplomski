.....
createVerticalToolbar(menuLayout);
.....




private void createVerticalToolbar(VerticalLayout lo) {
    newContact.setStyleName("img");
    newContact.setWidth("100%");
    newContact.setIcon(new ClassResource("../../com/image/document-add.png"));
    newContact.addListener((Button.ClickListener) this);
    lo.addComponent(newContact);
    search.setIcon(new ClassResource("../../com/image/folder-add.png"));
    search.addListener((Button.ClickListener) this);
    search.setWidth("100%");
    lo.addComponent(search);
    share.setIcon(new ClassResource("../../com/image/users.png"));
    share.addListener((Button.ClickListener) this);
    share.setWidth("100%");
    lo.addComponent(share);
    help.setIcon(new ClassResource("../../com/image/help.png"));
    help.addListener((Button.ClickListener) this);
    help.setWidth("100%");
    lo.addComponent(help);

    // Add new component which uses up the remaining space
    Label lbl= new Label("About");
    lo.addComponent(lbl);    
    lo.setExpandRatio(help, 20);

    lo.setMargin(true);
    lo.setSpacing(true);
    lo.setWidth("100%");
    lo.setSizeFull();
    return lo;
}