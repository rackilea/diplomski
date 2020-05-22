private void buildLayout() {
    HorizontalLayout actionBar = new HorizontalLayout(filter, addContact);
    actionBar.setWidth("100%");
    filter.setWidth("100%");
    actionBar.setExpandRatio(filter, 1);

    VerticalLayout left = new VerticalLayout(actionBar, contactList);
    left.setSizeFull();
    left.setExpandRatio(contactList, 1);

    addComponents(left, contactForm);
    contactForm.setVisible(false);
}