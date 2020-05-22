Series<Header> headers = (Series<Header>) cr.getAttributes().get(
            HeaderConstants.ATTRIBUTE_HEADERS);
if (headers == null) {
    headers = new Series<Header>(Header.class);
    cr.getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
}

headers.add("MyCustomHeader", "some value");