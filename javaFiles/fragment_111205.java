public class MyActivity extends AppCompatActivity implements MyFirebaseListener {

    void someMethod(){
        addNewUser(firstname, 
                lastname, 
                email, 
                gender,
                uid,
                profileImageUrl,
                this) // <- This will be reference to Activity with Type of MyFirebaseListener
    }

    void onSuccess(DocumentReference documentReference){
        mProgressBar.setVisibility(View.GONE);
        mIRegisterActivity.inflateFragment("Register Box", mHashMap);
        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
    }
    void onFailure(Exception e){
        Log.d(TAG, "Error adding document", e);
    }
}