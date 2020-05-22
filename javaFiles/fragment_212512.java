DROP TABLE IF EXISTS mytable;
CREATE TABLE IF NOT EXISTS mytable (_id INTEGER PRIMARY KEY, date INTEGER, content TEXT, important INTEGER);
-- add some data with unix dates with milliseconds (i.e. * 1000)
INSERT INTO mytable (date,content,important) VALUES(strftime('%s','now') * 1000,'blah',0);
INSERT INTO mytable (date,content,important) VALUES(strftime('%s','now','-1 Day') * 1000,'blah',0);
INSERT INTO mytable (date,content,important) VALUES(strftime('%s','now','-7 Day') * 1000,'blah',0);
INSERT INTO mytable (date,content,important) VALUES(strftime('%s','now','-10 Day') * 1000,'blah',0);
INSERT INTO mytable (date,content,important) VALUES(strftime('%s','now','-20 Day') * 1000,'blah',0);
INSERT INTO mytable (date,content,important) VALUES(strftime('%s','now','-1 Month') * 1000,'blah',0);
SELECT *, datetime(date/1000,'unixepoch') AS fulldate, strftime('%d',date/1000,'unixepoch') AS date_as_DD FROM mytable;