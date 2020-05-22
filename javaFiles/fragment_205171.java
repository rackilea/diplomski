public void actionPerformed(ActionEvent e) {
    bookstoreIndex--;

    // You want to check if the index is **BELOW** the range of acceptable
    if (bookstoreIndex < 0) {
        bookstoreIndex = bookInventory.length - 1;
    }
    prepareDisplay(bookInventory[bookstoreIndex], textArea);
  }