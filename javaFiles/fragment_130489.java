public class SplashScreen extends AppCompatActivity {
        SessionManagerFacebook sessionManagerFacebook = new SessionManagerFacebook(this);

if (sessionManagerFacebook.isLoggedIn()) {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));  
            }

   }