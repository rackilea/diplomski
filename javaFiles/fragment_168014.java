for(String query: queries) {
    stat.addBatch(query);
}

try {
    stat.executeBatch();
} catch(Exception e) {
    // ...
}