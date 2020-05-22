private static View viewLeak;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress);
        if(viewLeak == null){
            viewLeak = progressBar;
        }
    }