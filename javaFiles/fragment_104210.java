create procedure [dbo].[prSum]

AS
begin
    set nocount on;
    declare @SUM table (
         ClientName Varchar(40), 
         SearchDoc Varchar(20), 
         SearchName Varchar(20)
    )
    --each one of this procedures returns a query with the same colunms size of @SUM
    insert into @SUM exec pr1;
    insert into @SUM exec pr2;
    insert into @SUM exec pr3;
    insert into @SUM exec pr4;
    insert into @SUM exec pr5;

    Select * from @SUM;
    return;
end
GO