CREATE TABLE properties (
    foo_id INT8 NOT NULL,
    value VARCHAR(512),
    key VARCHAR(100) NOT NULL,
    PRIMARY KEY (user_id, key)
);