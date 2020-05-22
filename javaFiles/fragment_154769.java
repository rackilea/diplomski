DECLARE
  h1_false BOOLEAN := false;
  h6_ NUMBER;
BEGIN
  update_stored_proc(
  h1 => h1_false,
  h2 => :h2,
  h6 => h6_