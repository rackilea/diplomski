Book book = new Book();
Photo photo = new Photo();
book.addPhoto(photo);
photo.setBook(book);
//notice on the line above we set the backreference of the photo to the book.
hibernateSession.persist(book);
// now it is cascading from book to photo and it will set the foreign keys correctly.