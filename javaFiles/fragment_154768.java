DECLARE
  h1_false BOOLEAN;
  h6_ NUMBER;
BEGIN
  IF :h1 THEN
    h1_false = true;
  ELSE
    h1_false = false;
  END IF;

  update_stored_proc(
  h1 => h1_false,
  h2 => :h2,
  h6 => h6_
  );
END;