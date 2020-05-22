Http h = new Http();

HttpRequest req = new HttpRequest();
req.setEndpoint('https://example.herokuapp.com/ppt');
req.setMethod('GET');

HttpResponse res = h.send(req);
res.getBody();