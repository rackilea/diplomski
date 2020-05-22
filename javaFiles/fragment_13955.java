public class UserActivity extends Activity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.game_activity_layout);
         final GameModel viewModel = ViewModelProviders.of(this).get(GameModel.class);
         viewModel.gameLiveData.observer(this, new Observer() {
            @Override
             public void onChanged(@Nullable Game gameData) {
                 // update ui.
             }
         });
         findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                  // Pass parameters in doAction function to set the items in the Game class and update the ui accordingly inside the onChanged function.
                  viewModel.doAction(); 
             }
         });
     }
}