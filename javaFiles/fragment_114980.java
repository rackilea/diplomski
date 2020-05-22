if (selection == 2) {
            System.out.println("Editing a Book ");
            System.out.println("Please enter title of book to edit:");
            String title = input.next();

            Book editingBook = findBookByTitle(title);
            if(editingBook == null) {
                System.out.println("Sorry no book found with title name = " + title);
            } else {
                // Now ask user for new price etc what ever you want to edit.
                System.out.println("Please enter new price:");
                int newPrice = input.nextInt();
                editingBook.setPrice(newPrice);
                // etc. other editing to book.
            }
        }