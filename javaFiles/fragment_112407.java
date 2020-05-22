@Mock private PaginatedQueryList paginatedQueryList;
doReturn(mockQuery).when(utilSpy).getQueryExpression();

when(mockQuery.withFilterExpression(anyString())).thenReturn(mockQuery);
when(mockQuery.withLimit(anyInt())).thenReturn(mockQuery);
when(mockQuery.withExpressionAttributeValues(anyMap())).thenReturn(mockQuery);
when(mockQuery.withIndexName(anyString())).thenReturn(mockQuery);
when(mockQuery.withHashKeyValues(anyString())).thenReturn(mockQuery);
when(mockQuery.withConsistentRead(anyBoolean())).thenReturn(mockQuery); 
when(mockQuery.withRangeKeyCondition(anyString(), anyObject())).thenReturn(mockQuery);
when(mapper.query(any(), anyObject())).thenReturn(paginatedQueryList);