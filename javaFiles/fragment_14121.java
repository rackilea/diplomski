SELECT  s.Service_ID  
    , s.[Location_ID]  
    , COALESCE(st.[Service_Type_Name], s.[Service_Name]) AS Service_name 
    , st.Service_Type_Name 
FROM [WebApp].[dbo].[Services] s 
join [WebApp].[dbo].[ServiceTypes] st on s.Service_Type = st.Service_Type_ID 
join [WebApp].[dbo].[Locations] l on s.Location_ID = l.Location_ID  
where s.Deleted = 0  
ORDER BY Location_ID;