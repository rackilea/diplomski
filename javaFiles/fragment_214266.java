CREATE OR REPLACE FUNCTION update_employee(p_id INT, p_name VARCHAR(255), p_age INT, p_salary DECIMAL)
  RETURNS INT
LANGUAGE plpgsql
AS $$
BEGIN
  IF p_id IS NULL
  THEN
    INSERT INTO employee (name, age, salary) VALUES (p_name, p_age, p_salary) RETURNING id INTO p_id;
  ELSE
    UPDATE employee
    SET name = p_name, age = p_age, salary = p_salary
    WHERE id = p_id;
  END IF;
  RETURN p_id;
END;
$$;