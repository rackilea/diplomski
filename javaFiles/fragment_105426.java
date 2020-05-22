queries[0] = "SELECT id, name, etc, %d AS query FROM person WHERE ...";
// ...
queries[8756] = "SELECT id, name, etc, %d AS query FROM person WHERE ...";

for (int i = 0; i < queries.length; i++) {
    String sql = String.format(queries[i], i);
    // ...
}