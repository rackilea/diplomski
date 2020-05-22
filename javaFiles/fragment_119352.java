@Override
public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof Communicator )
        conn = (Communicator )context;
}

@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (activity instanceof Communicator )
        conn= (Communicator)activity;
}