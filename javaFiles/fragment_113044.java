String mockPage = "test page"; // length is 9 

 RequestBuilder requestBuilderMock = createNiceControl().createMock(RequestBuilder.class); expect(requestBuilderMock.get((Class < String >) anyObject())).andReturn("12345678").anyTimes(); replay(requestBuilderMock);

 WebResource webResourcemock = createNiceControl().createMock(WebResource.class); expect(webResourcemock.accept((String[]) anyObject())).andReturn(requestBuilderMock).anyTimes(); replay(webResourcemock);

 Client clientMock = createNiceControl().createMock(Client.class); expect(clientMock.resource((URI) anyObject())).andReturn(webResourcemock).anyTimes(); replay(clientMock);

 Loader mockedLoader = new Loader(clientMock); assertEquals((Integer) mockPage.length(), mockedLoader.getLength(new URI("http://example.com")));