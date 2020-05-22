CREATE TEMPORARY TABLE `import` (
        `person_name` varchar(300) CHARACTER SET latin1 NOT NULL,
        `person_age` varchar(300) CHARACTER SET latin1 NOT NULL,
        `address1` varchar(300) CHARACTER SET latin1 NOT NULL,
        `city` varchar(300) CHARACTER SET latin1 NOT NULL
    ) ENGINE=MEMORY DEFAULT CHARSET=utf8;