UriComponentsBuilder builder = UriComponentsBuilder
            .fromHttpUrl("https://example.com/api/")
            .queryParam("param1", "12345")
            .queryParam("param2", "abc");
// the parameter has to be properly url-encoded manually (not shown here)
String uri = builder.build().encode().toString() + "&query=username=JOE";

System.out.println(uri);
// produces: https://example.com/api/?param1=12345&param2=abc&query=username=JOE