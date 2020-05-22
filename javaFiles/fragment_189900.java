insert into author values (author_seq.nextval, other columns);
insert into author_books values (book_seq.nextval, author_seq.currval, other columns1);
insert into author_books values (book_seq.nextval, author_seq.currval, other columns2);
...
insert into author values (author_seq.nextval, other columns);
insert into author_books values (book_seq.nextval, author_seq.currval, other columns3);
insert into author_books values (book_seq.nextval, author_seq.currval, other columns4);