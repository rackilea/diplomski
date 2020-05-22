create or replace trigger mytable_emp_id_trigger
before insert on mytable
for each row
begin
    select emp_id_seq.nextval into :emp.id from dual;
end;
/