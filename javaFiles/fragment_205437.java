public void readData(MyCallback myCallback) {
    firestoreDB.collection("events")
        .whereEqualTo("type", eventType)
        .get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<Event> eventList = new ArrayList<>();

                    for(DocumentSnapshot doc : task.getResult()) {
                        Event e = doc.toObject(Event.class);
                        e.setId(doc.getId());
                        eventList.add(e);
                    }
                    myCallback.onCallback(eventList);
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
            }
        }

     });
}