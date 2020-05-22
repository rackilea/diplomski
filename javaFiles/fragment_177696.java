import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    // Constants

    //Images for the hangman
    @DrawableRes
    private final static int img[] = {R.drawable.img0, // Img0 is when the player is dead
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8};

    private final static String strWords[] = {"APPLE", "ORANGE", "BANANA"};
    private final static Random random = new Random(); //Random generator

    // To reference the components
    private ImageSwitcher imageSwitcher;
    private TextView textView;
    private TextView textViewScore;

    // Other private fields
    private Game mGame;

    public void startNewGame() {
        mGame = new Game(img.length - 1); // The max lives is the size of the array - 1
        setup26Buttons();
        initSecretWord();
        imageSwitcher.reset();
        imageSwitcher.setImageResource(img[mGame.livesRemaining]);
        textViewScore.setText(String.valueOf(mGame.livesRemaining));
        textView.setText(mGame.hiddenWord);
    }

    //To create help icon at top right
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //To create help icon at top right
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_help:
                showHelpDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Retrieve the reference
        imageSwitcher = findViewById(R.id.imageSwitcher);
        textView = findViewById(R.id.textView);
        textViewScore = findViewById(R.id.textViewScore);

        // Init the view components
        initImageSwitcher();

        // Start the game
        startNewGame();
    }

    private void setup26Buttons() {

        final GridLayout g = findViewById(R.id.gridLayout);
        g.removeAllViews(); // clear the children views (if exist)

        //to create 26 buttons
        final int maxLetters = 26;
        Button btn;
        for (int i = 0; i < maxLetters; i++) {

            btn = new Button(this, null, R.attr.buttonStyleSmall); //Buttonsytlesmall so that it fits the screen
            btn.setText(Character.toString((char) ('A' + i))); // Set the letter
            btn.setOnClickListener(listener);

            g.addView(btn);
        }
    }

    private final View.OnClickListener listener = new View.OnClickListener() {
        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View v) {

            String guess = (((Button) v).getText()).toString();
            v.setEnabled(false); //disable pressed button since the player already press
            v.setBackgroundColor(android.R.color.black);

            // Check if the current letter is in the secret word
            if (!mGame.secretWord.contains(guess)) {
                mGame.livesRemaining--; // Remove a live
                imageSwitcher.setImageResource(img[mGame.livesRemaining]); //set the img no. to follow the error
                textViewScore.setText(String.valueOf(mGame.livesRemaining));

                if (mGame.livesRemaining == 0) {
                    showEndGameDialog("Batman got executed!", "You lose!\n\nThe answer was:\n\n" + mGame.secretWord);
                }
            } else {
                mGame.correctGuess += guess; // Add the letter to the ones correctly guessed
                //Display all correct guesses
                final StringBuilder sb = new StringBuilder();
                final char[] chars = mGame.secretWord.toCharArray();
                for (int i = 0; i < mGame.secretWord.length(); i++) {
                    //To check if this letter can be found in correctGuess
                    sb.append((mGame.correctGuess.contains(Character.toString(chars[i])))
                            ? chars[i] //found
                            : "-");
                }
                mGame.hiddenWord = sb.toString();
                textView.setText(mGame.hiddenWord);

                // If all the unique letters in the word have been found, it's a win
                if (mGame.correctGuess.length() == mGame.maxLetters) {
                    showEndGameDialog("Amazing! You save Batman!", "The Hangman\'s favourite fruit is:\n\n" + mGame.secretWord);
                }
            }
        }
    };

    private void showEndGameDialog(String title, String message) {
        new AlertDialog.Builder(GameActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Play Again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GameActivity.this.startNewGame();
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GameActivity.this.finish();
                            }
                        })
                .show();
    }

    private void initSecretWord() {

        int index = random.nextInt(strWords.length);
        String secretWord = strWords[index];
        // Replace all the letters by '-' ('\p{L}' matches any letter)
        String hiddenWord = secretWord.replaceAll("\\p{L}", "-");

        mGame.maxLetters = countUniqueLettersInWord(secretWord);
        mGame.secretWord = secretWord;
        mGame.hiddenWord = hiddenWord;
    }

    /**
     * Calculate the number of unique letter in the word
     * E.g BANANA has 3 unique letters (B,A,N)
     *
     * @param word The word to count the unique letter in
     * @return The total of unique letters
     */
    private static int countUniqueLettersInWord(final String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        char curr;
        boolean contains;
        for (int i = 0; i < chars.length; i++) {
            curr = chars[i];
            // Check if the same letter exists in the visited letters (from pos 0 to current letter)
            contains = false;
            for (int j = 0; j < i; j++) {
                if (curr == chars[j]) {
                    contains = true;
                    break; // Don't need to continue if the letter already exists.
                }
            }
            if (!contains)
                count++;
        }

        return count;
    }

    private void initImageSwitcher() {

        //https://www.tutorialspoint.com/android/android_imageswitcher.htm
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return new ImageView(getApplicationContext());
            }
        });

        Animation aniOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation aniIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        imageSwitcher.setOutAnimation(aniOut);
        imageSwitcher.setOutAnimation(aniIn);
    }

    //show help information
    public void showHelpDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Help")
                .setMessage("Whisper the password (Hangman's favourite fruit) to save Batman\n\n"
                        + "You only have 8 tries!")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        })
                .show();
    }
}