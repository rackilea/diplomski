public void saveToDatabase() {
    // Do your thing to save the route

    // Save the markers to the database in one write operation
    schoolReference.child("markers").updateChildren(markers);
}