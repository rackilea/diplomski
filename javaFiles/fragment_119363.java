set serveroutput on
declare
  razotaji varchar2(80);
  razotaji := beerbeer.getBreweryInfo(3);
  dbms_output(razotaji);
end;
/