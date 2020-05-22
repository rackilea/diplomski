public void actionPerformed(ActionEvent e) {
    bookstoreIndex--; // ++ for the next button's listener

    bookstoreIndex += bookInventory.length; // in case it's < 0
    bokstoreIndex %= bookInventory.length; // put it in correct range

    prepareDisplay(bookInventory[bookstoreIndex], textArea);
  }