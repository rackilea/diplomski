@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

   if (savedInstanceState == null) {
       // Get the message from the intent
       Intent intent = getIntent();
       // Notice to specify the sender Activity for the message
       String station = intent.getStringExtra(WCBankActivity.EXTRA_MESSAGE);
       ...
       FragmentLineChooserList newFragment = new FragmentLineChooserList();
       FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
       transaction.replace(R.id.detail_container, newFragment);
       transaction.commit();
   }
}