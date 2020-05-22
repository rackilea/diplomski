public class Auth {

public static void authenticateStudentID(final String studentID, final AuthListener listener) {

    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("your reference");

    databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // wtf is this advanecd for loop
                //map string string because our key is a string and value is a string, map has a key and value object
                Map<String, String> map = (Map) snapshot.getValue();
                if (map != null) { //if the values and keys are not null
                    String studentIDMatch = map.get("studentID");

                    if (studentID.equals(studentIDMatch)) {

                        if (listener != null)
                            listener.onAuthSuccess();


                    } else {

                        if (listener != null)
                            listener.onAuthFailure();
                    }
                }
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            if (listener != null)
                listener.onAuthFailure();
        }
    });
}

public interface AuthListener {
    void onAuthSuccess();

    void onAuthFailure();
}