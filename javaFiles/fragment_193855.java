Class CustomFragment extends Fragment{
    private TextView nView;
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nView = view.findViewById(R.id.label);
    }

    public String getScore(){
        return nView.getText().toString();
    }
}