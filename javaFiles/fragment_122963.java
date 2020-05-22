<!-- sql -->
CREATE TABLE students    ( id  INTEGER,  name  varchar(60));

INSERT INTO students    ( id ,  name ) VALUES    (1, 'stud_1');
INSERT INTO students    ( id ,  name ) VALUES    (2, 'stud_2');
INSERT INTO students    ( id ,  name ) VALUES    (3, 'stud_3');
INSERT INTO students    ( id ,  name ) VALUES    (4, 'stud_4');
INSERT INTO students    ( id ,  name ) VALUES    (5, 'stud_5');

CREATE TABLE student_fee  (id INTEGER, studentId INTEGER, month varchar(20));

INSERT INTO student_fee    (id ,  studentId ,  month ) VALUES    (1, 1, 'january');
INSERT INTO student_fee    (id ,  studentId ,  month ) VALUES    (2, 2, 'january'); 
INSERT INTO student_fee    (id ,  studentId ,  month ) VALUES    (4, 2, 'february');
INSERT INTO student_fee    (id ,  studentId ,  month ) VALUES    (5, 3, 'february');
INSERT INTO student_fee    (id ,  studentId ,  month ) VALUES    (6, 4, 'february');