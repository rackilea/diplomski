create or replace 
FUNCTION xyz RETURN VARCHAR
IS
k Varchar(135);
begin
    k:= 'abc';
RETURN k;
end;