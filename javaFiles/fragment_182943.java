viewModel.insert(myUser).observe(this, isComplated -> {
    if (isComplated != null && isComplated) {
        Intent i = new Intent(AddUser.this, MainActivity.class);
        ctx.startActivity(i);
    }
});