Create table Test(
   id int,
   name text,
   address list<frozen<address>>,
   primary key(id)
);