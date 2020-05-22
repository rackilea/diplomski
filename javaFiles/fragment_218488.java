cursor  = coll.find(query);
int count = cursor.count();

if (count >= 1) {
    // Found
    System.out.println(cursor.next());
} else {
    // Not found
}