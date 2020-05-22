create trigger b_trg 
after update on B for each row
begin
    update a
     set a.b_id = a.b_id
     where a.b_id = :old.b_id
    ;
end;