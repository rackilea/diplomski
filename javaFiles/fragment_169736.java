public class Database {

private FirebaseAuth connect_databse;

private boolean authorisation;

public Database() {

}

public void sign_in(String user_name, String Password,final OnCompleteListener listener) {

    authorisation = false;

    connect_databse = FirebaseAuth.getInstance();

    connect_databse.signInWithEmailAndPassword(user_name, Password)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser user = connect_databse.getCurrentUser();
                        authorisation =  true;
                        System.out.println("here 1");
                        listener.onComplete();
                        System.out.println("here 2");
                    }
                }
            });
}