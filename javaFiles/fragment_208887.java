btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        getFragmentManager()
            .beginTransaction()
            .replace(...) //Or add, depends on your use case
            .commit();
    }
});