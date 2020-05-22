public void onClickMethodForOnClickListenerOrSomething(View view) {
    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
    .setAction("Action", null).show();
}

public void yourOtherMethod() {
  fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          onClickMethodForOnClickListenerOrSomething(view);
        }
    });
}