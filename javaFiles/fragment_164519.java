.setProperty("projectId", simple("body['projectId']"))
            .setProperty("title", simple("body['title']"))
            .setBody(simple("body['partners']"))
            .split(simple("body"))
            .process{//prepare your properties here}
            .end()
            .to("sql:classpath:sql/sql_queries.sql");