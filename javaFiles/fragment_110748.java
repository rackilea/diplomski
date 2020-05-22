public class PaymentsActivity extends Activity implements Controller.ControllerUpdateListener {
    ProfileModel profile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.payment_history);

        Controller.addListener(this); // <-- Don't forget this...
        profile = Controller.getProfile();

        ListView itemList = (ListView)this.findViewById(R.id.payment_history_list);
        itemList.setTextFilterEnabled(true);
        itemList.clearChoices();
        itemList.setAdapter(new ItemSummaryAdapter(PaymentsActivity.this, R.layout.list_item_payment, profile.Items));
        //statementList.setOnItemClickListener(clickListener);
    }

    public void onControllerUpdate(ProfileModel model) {
        //update these views...
    }
}