// (I am using the deprecated constructor for simplicity)
java.sql.Date startDate = new java.sql.Date(2018, 6, 5);
Mockito.when(mockResultSet.getDate("startDate")).thenReturn(startDate);
ElectionListResponse response = adminDao.getElections('>' );
Election firstElection = response.getFirst() // Or whatever method(s) get you the first one
Assert.assertEquals("2018-06-05 00:00", firstElection.getStartDate());