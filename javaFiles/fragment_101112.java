janko=# CREATE TABLE blobtest1 (name CHAR(30), image OID);
CREATE TABLE                                              
janko=# INSERT INTO blobtest1 VALUES ('stackoverflow', lo_import('/tmp/stackoverflow-logo.png'));
INSERT 0 1
janko=# SELECT * FROM blobtest1;
              name              | image
--------------------------------+-------
 stackoverflow                  | 16389
(1 row)