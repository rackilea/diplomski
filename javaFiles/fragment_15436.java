public class Question05 extends AppCompatActivity {

    ...

    private void checkIfQuestion05IsCorrect() {
        if (correct) {
            // They answered right, move to the next question.
            // But before we do that, let's save the fact that they answered right.

            SharedPreferences.Editor editor = getSharedPreferences("FILENAME", MODE_PRIVATE).edit();
            editor.putBoolean("Question05", true);
            editor.apply();
        } else {
            // they got it wrong
        }
    }

}