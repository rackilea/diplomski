static CompletionStage<String> insert(Object database) {
    throw new UnsupportedOperationException();
}

static CompletionStage<Object> get(String id) {
    throw new UnsupportedOperationException();
}

public static void main(String[] args) throws InterruptedException {

    Object db = new Object(); // pretend this connects to a database
    CompletionStage<Object> recordInserted = insert(db).thenCompose(id -> get(id));
}