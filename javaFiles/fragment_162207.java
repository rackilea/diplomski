override fun doWork(): Result {
    val latch = CountDownLatch(1)
    val firebaseDatabaseRef = FirebaseDatabase.getInstance().reference
    firebaseDatabaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // Handle DataSnapshot
            latch.countDown()
        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Handle DatabaseError
            latch.countDown()
        }
    })

    latch.await()
    return Result.SUCCESS
}