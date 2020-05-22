SELECT  b.id AS id1_0_
FROM    book b
WHERE   b.isbn = '978-9730228236'

SELECT  b.id AS id1_0_0_ ,
        b.isbn AS isbn2_0_0_ ,
        b.properties AS properti3_0_0_
FROM    book b
WHERE   b.id = 1

-- Book details: {"price":44.99,"title":"High-Performance Java Persistence","author":"Vlad Mihalcea","publisher":"Amazon"}

UPDATE
    book 
SET
    properties = '{"title":"High-Performance Java Persistence","author":"Vlad Mihalcea","publisher":"Amazon","price":44.99,"url":"https://www.amazon.com/High-Performance-Java-Persistence-Vlad-Mihalcea/dp/973022823X/"}'
WHERE
    id = 1