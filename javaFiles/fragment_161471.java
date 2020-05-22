public class Puzzle extends Activity {

     public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            WordPuzzle wp = new WordPuzzle(); // you need to make main() a static function to avoid this
            String args[] = {""};
            wp.main(args);
  }