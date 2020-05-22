MERGE INTO Test_table t
USING (SELECT 461232 ID,'Test1-data' Fascia --FROM Test_table
      ) s
ON (t.ID = s.ID)
WHEN MATCHED THEN
UPDATE SET t.Fascia = s.Fascia 
WHEN NOT MATCHED THEN
INSERT (Fascia)
VALUES (s.Fascia);