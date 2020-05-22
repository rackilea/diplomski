<sql:transaction>
   <sql:query var="order" 
      dataSource="${applicationScope.orderDS}">
         select * from PUBLIC.orders where id = ?
         <sql:param value="${id}" />
   </sql:query>
   <sql:update var="order" 
      sql="update PUBLIC.orders set book_name = ? where id = ?">
         <sql:param value="${name}" />
         <sql:param value="${id}" />
   </sql:query>
<sql:transaction>