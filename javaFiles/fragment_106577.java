@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState != null) {
        int position = savedInstanceState.getInt(TAG,0);
        //set ball position

        //or get the object back using outstate.getSerializable(TAG) 

    }
}