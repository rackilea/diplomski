ALTER PROCEDURE dbo.TroublesomeSP AS
BEGIN
    -- note: no `SET NOCOUNT ON;`
    DECLARE @tbl TABLE (id VARCHAR(3) PRIMARY KEY);

    DROP TABLE NonExistent;
    INSERT INTO @tbl (id) VALUES ('001');
    SELECT id FROM @tbl;
    INSERT INTO @tbl (id) VALUES ('001');  -- duplicate key error
    SELECT 1/0;  -- error _inside_ ResultSet
    INSERT INTO @tbl (id) VALUES ('101');
    INSERT INTO @tbl (id) VALUES ('201'),('202');
    SELECT id FROM @tbl;
END