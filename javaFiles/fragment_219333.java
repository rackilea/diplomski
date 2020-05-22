public Controller() {
    listingJFrame = new ListingEmployesJFrame();
    EmployeJFrame = new addEmployeJFrame();
    EmployeJFrame.addAddEmployeJFrameObserver(this);

    listingJFrame.setVisible(true);
    EmployeJFrame.setVisible(true);

    // * add the line below to register listingJFrame as an observer *
    addListingEmployesJFrameObserver(listingJFrame);
}