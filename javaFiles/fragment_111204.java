public class UserApi{

    public void addNewUser(String firstname, 
                String lastname, 
                String email, 
                Integer gender, 
                String uid, 
                String profileImageUrl,
                MyFirebaseListener myFirebaseListener){

        Map<String, Object> data = new HashMap<>();
        data.put("firstname", firstname);
        data.put("lastname", lastname);
        data.put("email", email);
        data.put("gender", gender);
        data.put("boxId", "independent");
        data.put("notificationsEnabled", true);
        data.put("profileImageUrl", profileImageUrl);

        mFirebaseFirestore.collection("usersP").add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        myFirebaseListener.onSuccess(documentReference)
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        myFirebaseListener.onFailure(e)
                    }
                });

    }
}