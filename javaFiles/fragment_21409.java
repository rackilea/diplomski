CREATE OR REPLACE FUNCTION  public.testDynamicReturn(_tagId character varying)
    RETURNS TABLE (out_rollNum character varying, out_name character varying, out_gaurdian character varying) 
    AS 
    $func$
    BEGIN
     IF _tagId = 'stu' then 
               --validate your select, ensure it works independently
               RETURN QUERY  SELECT "StudentRollNo.","StudentName","GuardianName" FROM public."DetailsOfStudents";  
               END IF;
         IF _tagId = 'teach' then 
               --validate your select, ensure it works independently
               RETURN QUERY  SELECT "StudentRollNo.","StudentName", CAST (null AS character varying) "GuardianName" FROM public."DetailsOfStudents";
               END IF;

    END
    $func$  LANGUAGE plpgsql;