final View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //do something
            Log.v("TAG", "You clicked the action");
        }
}
CustomSnackbar customSnackbar = new CustomSnackbar(activity);
customSnackbar.make(view, "This is my snackbar", Snackbar.LENGTH_INDEFINITE);
customSnackbar.setAction("HIDE", ocl);
customSnackbar.show();