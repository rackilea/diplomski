CREATE TABLE model_a (
    _id INTEGER PRIMARY KEY, 
    field TEXT NOT NULL 
);

-- Table for Model_B
CREATE TABLE model_b (
    _id INTEGER PRIMARY KEY, 
    model_a_id INTEGER NOT NULL, 
    field_2 TEXT NOT NULL, 
    FOREIGN KEY model_a_id REFERENCES model_a(_id) 
);