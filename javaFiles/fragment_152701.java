final QueryResult[] results = new QueryResult[N_THREADS];
for (int i = 0; i < N_THREADS; i++) {
    ...
        public void run() {
            results[j] = data.get(Query.values()[j % Query.values().length]);
        }