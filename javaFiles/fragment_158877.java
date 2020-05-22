declare 
 type CHAR_TABLE IS TABLE OF CHAR(06) INDEX BY BINARY_INTEGER;
 p_strings  CHAR_TABLE;
 idx BINARY_INTEGER;
begin 
 p_strings(0) := 'aaaa';
 p_strings(1) := 'bbbb';
 p_strings(2) := 'cccc';
 -- 1-st option
 FOR i IN 0..p_strings.last  loop
  dbms_output.put_line(p_strings(i));
 end loop;
 -- 2-nd option
 idx := p_strings.first;
 while idx is not null
 loop
  dbms_output.put_line(p_strings(idx));
  idx := p_strings.next(idx);
 end loop;

end;