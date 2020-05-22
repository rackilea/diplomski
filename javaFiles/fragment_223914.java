@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    if(savedInstanceState!=null)
    {
        int a=savedInstanceState.getInt("cp");
        videoview.seekTo(a);
    }

//the rest of your code then....
}