query.setReadOnly(true);
query.setCacheable(false);
ScrollableResults results = query.scroll(ScrollMode.FORWARD_ONLY);

while (results.next()) {
    SomeEntity entity = results.get()[0];
}
results.close();