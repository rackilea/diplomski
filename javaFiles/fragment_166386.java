create or replace procedure my_procedure_one (returnval in out date) is
begin

   -- some stuff.
   if sdate > sysdate then
      returnval := sdate;
      -- we don-t want to continue any more if this is true.
      return;
   end if;
   -- more stuff.
end;