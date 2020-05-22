String url = "http://example.com/foo/?bar=15&oof=myp";

UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(url);

urlBuilder.replaceQueryParam("bar", 107);

String result = urlBuilder.build().toUriString();