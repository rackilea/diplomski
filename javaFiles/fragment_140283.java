CREATE OR REPLACE FUNCTION public.get_metadata(
var1 text,
sort text)
RETURNS TABLE(fldvalue text) 
LANGUAGE 'plpgsql'
COST 100
VOLATILE 
ROWS 1000
AS $BODY$

 BEGIN

  IF(sort='asc') THEN
  RETURN QUERY SELECT distinct metadata->>var1 as fldvalue FROM documents WHERE metadata?var1 order by fldvalue asc;
  ELSE 
  RETURN QUERY SELECT distinct metadata->>var1 as fldvalue FROM documents WHERE metadata?var1 order by fldvalue desc;
  END IF;
END

$BODY$;