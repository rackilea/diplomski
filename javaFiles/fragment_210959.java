<sql:query var="examples" dataSource="${exampleDataSource}">
    select ExampleName as "name"
    from ExampleTable 
    where ExampleId = ?::integer
    order by ExampleName ASC
    <sql:param value="${param['ID']}"/>
</sql:query>