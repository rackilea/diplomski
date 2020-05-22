CREATE OR REPLACE TRIGGER NameChange
    BEFORE INSERT
    ON yourtable
    FOR EACH ROW
BEGIN
    IF :new.name = 'amitrai'
    THEN
        :new.name := '&^&WQWSAKJSJA';
    END IF;
END;