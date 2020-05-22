Query searchUserQuery = new Query((Criteria.where("userName").is("rohit")));
searchUserQuery.addCriteria((Criteria.where("search.key").is("foo")));
searchUserQuery.addCriteria((Criteria.where("search.XYZ.id").is("10")));

This will return a result where userName is "rohit", search Key value is "foo" and XYZ class contains id =10.

Its working for me!!!.