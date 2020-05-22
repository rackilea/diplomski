Remove  RegisterUser(); from onCreate

    and try this - 

        private void doNormalLogin(String email, String password){
      FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    } else {
                    Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

Make sure you added this in your app gradle dependencies  and the bottom plugin also - 

  dependencies {
      implementation fileTree(include: ['*.jar'], dir: 'libs')
      implementation 'com.google.firebase:firebase-auth:11.2.2'
      implementation 'com.google.firebase:firebase-database:11.2.2'
  }
  apply plugin: 'com.google.gms.google-services'

  And in your Project gradle -

  dependencies {
       classpath 'com.android.tools.build:gradle:3.2.1'
       classpath 'com.google.gms:google-services:4.2.0'
   }