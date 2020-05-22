public void actionPerformed(ActionEvent e) {
    bookstoreIndex--;

    // this checks if the index is **ABOVE** the range of acceptable
    if (bookstoreIndex == bookInventory.length - 1) {
        bookstoreIndex=0;
    }
    prepareDisplay(bookInventory[bookstoreIndex], textArea);
  }