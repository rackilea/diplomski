LOAD DATA INFILE 'c:/tmp/file.csv' 
    INTO TABLE person 
    (@dummy, person_name, person_age, address1, city)
    SET uuid = UUID()
    FIELDS TERMINATED BY ',' 
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 ROWS;