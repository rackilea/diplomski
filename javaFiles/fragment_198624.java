public class BowlerActivity extends AppCompatActivity {

    private BowlerAdapter mAdapter;
    private List<Bowler> bowlersList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DatabaseHelper db;
    private Button addbowler;
    private EditText newbowler;
    private TextView leagueId, noBowlersView;
    private String savedLeagueId;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        addbowler = this.findViewById(R.id.addbowler); // For testing
        leagueId = this.findViewById(R.id.tvLeagueId);
        noBowlersView = this.findViewById(R.id.noBowlersView);
        recyclerView = this.findViewById(R.id.recycler_view);
        db = new DatabaseHelper(this);

        savedLeagueId = "0"; //<<<< HARD CODED rather than get from IntentExtra
        leagueId.setText(savedLeagueId);
        bowlersList = db.getAllBowlers(leagueId.getText().toString());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BowlerAdapter(this,bowlersList);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        addbowler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBowlerDialog(false, null, -1);
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(mContext,"You clicked me", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(mContext,"You long clicked me", Toast.LENGTH_SHORT).show();
                showActionsDialog(position);

            }
        }));
    }

    //Opens Dialog With Edit/Delete Options
    //Edit - 0
    //Delete - 0
    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose option");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showBowlerDialog(true, bowlersList.get(position), position);
                } else {
                    deleteBowler(position);
                }
            }
        });
        builder.show();
    }

    //Toggling List And Empty Bowler View
    private void toggleEmptyBowlers() {
        //You Can Check bowlerList.size() > 0

        if (db.getBowlersCount() > 0) {
            noBowlersView.setVisibility( View.GONE);
        } else {
            noBowlersView.setVisibility( View.VISIBLE);
        }
    }

    //Inserting New Bowler In The Database And Refreshing The List
    private void createBowler(String leagueId,  String bowlerName) {
        //Inserting Bowler In The Database And Getting Newly Inserted Bowler Id
        long id = db.insertBowler(leagueId, bowlerName);

        //Get The Newly Inserted Bowler From The Database
       bowlersList = db.getAllBowlers(leagueId);
       mAdapter.notifyDatasetChanged(bowlersList);
       //mAdapter.notifyDataSetChanged();
    }

    //Updating Bowler In The Database And Updating The Item In The List By Its Position
    private void updateBowler(String bowlerName, int position) {
        Bowler n = bowlersList.get(position);

        //Updating Bowler Text
        n.setLeagueId(savedLeagueId);
        n.setName(bowlerName);

        //Updating The Bowler In The Database
        db.updateBowler(n);

        //Refreshing The List
        bowlersList.set(position, n); //<<<<< does not change the bowlerlist in the adapter
        //mAdapter.notifyItemChanged(position); // Saying that nothing has changed
        mAdapter.notifyDatasetChanged(db.getAllBowlers(savedLeagueId)); //<<<<< rebuilds adapter bowler list
        toggleEmptyBowlers();
    }

    //Deleting Bowler From SQLite Database And Removing The Bowler Item From The List By Its Position
    private void deleteBowler(int position) {
        //Deleting The Bowler From The Database
        db.deleteBowler(bowlersList.get(position));


        //Removing The Bowler From The List
        bowlersList.remove(position);
        //mAdapter.notifyItemRemoved(position); // Saying that nothing has changed
        mAdapter.notifyDatasetChanged(db.getAllBowlers(savedLeagueId));
        toggleEmptyBowlers();
    }

    public interface ClickListener{
        void onClick(View view,int position);
        void onLongClick(View view,int position);
    }

    //Show Alert Dialog With EditText Options to Enter/Edit A League
    //When shouldUpdate = true, It Will Automatically Display Old Bowler Name And Change The Button Text To UPDATE
    private void showBowlerDialog(final boolean shouldUpdate, final Bowler bowler, final int position) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.dialog_bowler, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(BowlerActivity.this);
        alertDialogBuilderUserInput.setView(view);

        leagueId.setText(savedLeagueId);
        final EditText inputBowlerName = view.findViewById(R.id.etBowlerNameInput);
        TextView dialogTitle = view.findViewById(R.id.dialog_title);
        dialogTitle.setText(!shouldUpdate ? getString(R.string.lbl_new_bowler_title) : getString(R.string.lbl_edit_bowler_title));

        if (shouldUpdate && bowler != null) {
            leagueId.setText(bowler.getLeagueId());
            inputBowlerName.setText(bowler.getName());

        }
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton(shouldUpdate ? "update" : "save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {

                    }
                })
                .setNegativeButton("cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Show Toast Message When No Text Is Entered
                if (TextUtils.isEmpty(inputBowlerName.getText().toString())) {
                    Toast.makeText(BowlerActivity.this, "Enter Bowler!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    alertDialog.dismiss();
                }

                //Check If User Is Updating Bowler
                if (shouldUpdate && bowler != null) {

                    //Updating Bowler By Its Id
                    updateBowler(inputBowlerName.getText().toString(), position);

                } else {
                    //Creating New Bowler
                    createBowler(leagueId.getText().toString(), inputBowlerName.getText().toString());
                }
            }
        });
    }
}