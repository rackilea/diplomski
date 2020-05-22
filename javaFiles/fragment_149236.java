UriComponentsBuilder builder = UriComponentsBuilder
            .fromHttpUrl("https://example.com/api/")
            .queryParam("param1", "12345")
            .queryParam("param2", "abc")
            .query("query=username=JOE");

System.out.println(builder.build().toString()); 
// produces https://example.com/api/?param1=12345&param2=abc&query=username=JOE

System.out.println(builder.build().encode().toString());
// produces https://example.com/api/?param1=12345&param2=abc&query=username%3DJOE