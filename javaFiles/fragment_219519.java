CREATE PROC dbo.MyProc @MyParam int OUTPUT AS
BEGIN

    SET @MyParam = 1;
END;
GO

DECLARE @MyParam int;
EXEC dbo.MyProc @MyParam OUTPUT;

PRINT @MyParam; --1