CREATE OR REPLACE TRIGGER update_passenger
AFTER UPDATE OF passenger
FOR EACH ROW
BEGIN
   UPDATE passenger
   SET
       paying = NVL(:NEW.adult, 0) + NVL(:NEW.child, 0),
       non_paying = NVL(:NEW.infant, 0) + NVL(:NEW.crew, 0),
       total_passenger = NVL(:NEW.adult, 0) + NVL(:NEW.child, 0) +
                         NVL(:NEW.infant, 0) + NVL(:NEW.crew, 0)
END;