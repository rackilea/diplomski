ALTER PROCEDURE [dbo].[MyProcedureName] @minutes int 
AS 
   SET nocount ON

    DECLARE @Message VARCHAR(40); 

      SET @Message = ' Completed, ' 

      -- <Your code> --- @minutes 

        SELECT @Message