watchProgram(InfoItem item) {
    // do stuff
    if (item instanceof Item) { // thanks to ruslan for if statement
        Item castedItem = (Item)item;
        castedItem.changeRecorded();
    }
    // do stuff
}