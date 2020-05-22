CREATE TABLE tableA 
(   id int auto_increment primary key,
    w INT(8) ZEROFILL NOT NULL, 
    x INT(8) NOT NULL,
    y int signed not null,
    z int unsigned not null,
    shortBinaryCharString char(10) binary not null,
    myBlob blob(10000) null
);