INSERT INTO employee_details("EMP_ID", "NAME", "VECH_NO", "SALARY")
(
    SELECT r."EMP_ID", r."NAME", r."VECH_NO", r."SALARY"
    FROM
        json_array_elements('[{"EMP_ID":1,"NAME":"Y","VECH_NO":4587,"SALARY":1500},{"EMP_ID":3,"NAME":"Z","VECH_NO":4007,"SALARY":1800}]') AS a(element),
        json_populate_record(NULL::employee_details, a.element) AS r
)
ON CONFLICT ("EMP_ID") DO
UPDATE SET
    "NAME" = EXCLUDED."NAME",
    "VECH_NO" = EXCLUDED."VECH_NO",
    "SALARY" = EXCLUDED."SALARY"
;