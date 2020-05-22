public class FragmentsActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        Fragment fragA = new WaitingTransaction();

        FragmentTransaction fragTrans = this.getSupportFragmentManager().beginTransaction();
        fragTrans.add(R.main.waiting, fragA);
        fragTrans.commit();
    }

    private void afterProcessing(){

                //show hidden layout and make the waiting hidden through visibility, then add the fragment bellow...
        FragmentTransaction fragTrans = this.getSupportFragmentManager().beginTransaction();
        fragTrans.add(R.main.layout_list_items,
                          new FragmentList());
        fragTrans.replace(R.main.layout_detail,
                          new FragmentB());
        fragTrans.commit();
    }

}