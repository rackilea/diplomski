class FragmentB extends Fragment {

    private int id;

    public static FragmentB newInstance(int id){
         Bundle args = new Bundle();
         args.putInt("id", id);
         FragmentB frag = new FragmentB();
         frag.setArguments(args);
     }


    public void onCreate(Bundle b){
       super.onCreate(b);
       this.id = getArguments().getInt("id);
    }

}