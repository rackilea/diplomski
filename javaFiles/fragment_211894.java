viewModel.getUser().observe(this, new Observer<User>() {
    @Override
    public void onChanged(@Nullable User user) {
        // Some code
    }
});