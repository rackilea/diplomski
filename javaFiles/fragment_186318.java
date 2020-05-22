create procedure dbo.mysequence_restart as 
begin
set nocount, xact_abort on;
  declare @restartSequence nvarchar(256);
  declare @restartWith nvarchar(10); = convert(nvarchar(10),isnull((
    select max(id)+1 
    from organisation 
    where customer_number is not null
    ), 1));

  set @restartSequence = 'alter sequence dbo.mysequence restart with '+@restartWith+';'; 
  exec sp_executesql @restartSequence;
end;
go