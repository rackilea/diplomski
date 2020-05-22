CREATE TABLE IF NOT EXISTS `shirts` 
( 
     `id` INT NOT NULL AUTO_INCREMENT ,
     `name` VARCHAR(10) NOT NULL ,           --updated
     `iid` INT NOT NULL ,
     `desc` VARCHAR(10) NOT NULL ,           --updated
     `shelf` VARCHAR(10) NOT NULL ,          --updated
     `gender` VARCHAR(10) NOT NULL ,         --updated
     `chestsize` FLOAT(4,2) NOT NULL ,
     `waistsize` FLOAT(4,2) NOT NULL ,
     `seatsize` FLOAT(4,2) NOT NULL ,
     `bicepsize` FLOAT(4,2) NOT NULL ,
     `shirtlength` FLOAT(4,2) NOT NULL ,
     `shirtwidth` FLOAT(4,2) NOT NULL ,
     `sleevelength` FLOAT(4,2) NOT NULL ,
     `collarsize` FLOAT(4,2) NOT NULL ,
     `picture` LONGBLOB NOT NULL ,
     `rented` BOOLEAN NOT NULL ,
     PRIMARY KEY (`id`)

);