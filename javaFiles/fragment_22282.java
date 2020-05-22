SELECT d.C_ContactID, d.C_EmailAddress, d.C_DataSourceID, d.C_DateCreated 
FROM duplicates d
WHERE EXISTS (select 1
              from duplicates 2
              where d2.C_DataSourceId = d.C_DataSourceId and
                    d2.C_DateCreated > d.C_DateCreated
             );