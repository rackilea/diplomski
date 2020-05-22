CREATE TABLE Books (
    BookId INT auto_increment primary key,
    Title VARCHAR(255)
);

CREATE TABLE Authors (
    AuthorId INT auto_increment primary key,
    Name VARCHAR(255)
);

CREATE TABLE BookAuthors (
    BookAuthorId INT auto_increment primary key,
    AuthorId INT, 
    BookId INT, 
    CONSTRAINT fk_BookAuthor_BookId FOREIGN KEY (BookId) REFERENCES Books(BookId),
    CONSTRAINT fk_BookAuthor_AuthorId FOREIGN KEY (BookId) REFERENCES Authors(AuthorId),
    UNIQUE (AuthorId, BookId)
);