String A = 
given ().
when().
get/put/post({api/name})
.extract()
.path("Students[0].Course.AccountNumber");

String B = 
given ().
when().
get/put/post({api/name})
.extract()
.path("Students[0].AccountNumber");

Assert.assertEquals(A, B);