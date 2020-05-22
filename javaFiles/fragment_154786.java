public class MainActivity extends AppCompatActivity {

    ...

    // Request code for handling the GameActivity result
    // make it final so it can be changed.
    private static final int gameOverRequestCode = 777;

    // Start GameActivity
    private void startTheGame() {
      Intent intent = new Intent(this, GameActivity.class);
      // start the GameActivity and wait for the result.
      startActivityForResult(intent, gameOverRequestCode);
    }


    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      switch (requestCode) {

        // Handle the result from GameActivity.
        // when the result is accepted from GameActivity, start the GameOverActivity.
        case gameOverRequestCode:
          if (resultCode == Activity.RESULT_OK) {
            Intent intent = new Intent(this, GameOverActivity.class);
            startActivity(intent);
          }
          break;
      }
    }

    ...
}