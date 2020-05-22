Class CustomFragment extends Fragment{
    private TextView nView;

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nView = view.findViewById(R.id.label);
        Button button = (Button)findViewByid(R.id.button)
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String highScore = nView.getText().toString()
                intent.putExtra(HIGH_SCORE, highScore);
                startActivity(intent);
            }
        });
    }
}