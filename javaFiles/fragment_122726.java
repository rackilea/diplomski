@Override
public void onDataChange(DataSnapshot snapshot) {
    for (DataSnapshot chatSnapshot: snapshot.getChildren()) {
        String key = chatSnapshot.getKey();
        System.out.println(key);
    }
}