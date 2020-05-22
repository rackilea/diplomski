create table scores
(   id int auto_increment primary key,
    categoryID varchar(10) not null,
    relevanceScore float not null,
    date_time datetime not null
);
truncate table scores;
insert scores (categoryID,relevanceScore,date_time) values
('AD', '110', '2015-08-26 14:59:51'), 
('DC', '110', '2015-08-26 14:59:51'), 
('DO', '110', '2015-08-26 14:59:51'), 
('EC', '8.087601288990395', '2015-08-26 14:59:53'), 
('EC', '110', '2015-08-26 14:59:51'),
('OLD1', '110', '2014-08-26 14:59:51'),
('OLD2', '110', '2014-08-26 14:59:51');