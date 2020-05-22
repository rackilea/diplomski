cursor  = coll.find(query);

if (cursor.hasNext()) {
    // Found
    System.out.println(cursor.next());
} else {
    // Not found
}