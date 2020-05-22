public void buttonPressed(int buttonID) {
    if(buttonID < slots.length) {
        //The item in inHand is now placed into swapSpot
        Item swapSpot = inHand;
        //The null value in slots[buttonID].storedItem is now placed in inHand
        inHand = slots[buttonID].storedItem;
        //The item previously in inHand is now placed in slots[buttonID].storedItem
        slots[buttonID].storedItem = swapSpot;
    }
}