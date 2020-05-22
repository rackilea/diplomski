CREATE TABLE my_test_tab (
  user_id NUMBER,
  day1 NUMBER,
  day2 NUMBER
);

INSERT INTO my_test_tab VALUES (1, 5, 10);
INSERT INTO my_test_tab VALUES (1, 1, 2);

COMMIT;

CREATE OR REPLACE FUNCTION GETTOTAL(v_user_id IN NUMBER)
RETURN NUMBER
AS
    v_result number := 0;
BEGIN
    SELECT SUM(DAY1+DAY2) INTO v_result FROM my_test_tab WHERE USER_ID = v_user_id;
RETURN v_result;
END;
/