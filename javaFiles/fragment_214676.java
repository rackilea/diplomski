@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    if(activity instanceof OnItemSelectedListener){
        Log.d("context is not of ", "onAttach:");
        listener = (OnItemSelectedListener) activity;
    }else{
        throw new ClassCastException(activity.toString()+" must implement MyListFragment.OnItemSelectedListener");
    }

}