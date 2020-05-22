try {
    Snackbar.make(v, snapbarString, Snackbar.LENGTH_LONG)
            .setAction(snapbarTitle, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // no implementation required
                }
            }).show();
} catch (NoClassDefFoundError e) {
    Toast.makeText(v.getContext(), snapbarString, Toast.LENGTH_LONG).show();
}