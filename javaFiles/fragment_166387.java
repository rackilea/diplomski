create or replace procedure my_procedure_two (returnval in out date) is
begin

   -- some stuff.

   -- we don-t want to continue any more if this is true.
   if sdate > sysdate then
      return;
   end if;

   returnval := sdate;
   -- more stuff.
end;