create table if not exists thread_question(

    question_id INT NOT NULL auto_increment,
    user_id id INT NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    question_title VARCHAR(500) NOT NULL,
    question VARCHAR(100000) NOT NULL,
    question_dateTime VARCHAR(100) NOT NULL,
    PRIMARY KEY(question_id)
    );