final Response res = this.origin.act(req);
for (int count = req.body().available(); count > 0;
    count = req.body().available()) {
    long skippedBytes = body().skip(count);
    if (skippedBytes != count) {
        // do something
    }
}
return res;