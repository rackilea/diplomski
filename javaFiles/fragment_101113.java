janko=# CREATE TABLE blobtest2 (name CHAR(30), image BYTEA);
CREATE TABLE
janko=# INSERT INTO blobtest2 VALUES ('somebinary', E'\\336\\255\\276\\357\\336\\255\\276\\357');
INSERT 0 1
janko=# SELECT * FROM blobtest2;
              name              |              image
--------------------------------+----------------------------------
 somebinary                     | \336\255\276\357\336\255\276\357
(1 row)