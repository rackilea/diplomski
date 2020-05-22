INSERT INTO address (id, address1, city)
    SELECT uuid, address1, city
    FROM `import`;

    INSERT INTO person (address_id, person_name, person_age)
    SELECT uuid, person_name, person_age
    FROM `import`;