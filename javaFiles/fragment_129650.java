DECLARE @PageNumber int = 1;
DECLARE @PageSize int = 20;

WITH Q AS
(
    SELECT *, ROW_NUMBER() OVER (ORDER BY TheOrderColumn) AS record_number
    FROM YourOriginalQuery
)
SELECT *
FROM Q
WHERE 
    record_number > (@PageNumber - 1) * @PageSize
    AND record_number <= @PageNumber * @PageSize
ORDER BY record_number;