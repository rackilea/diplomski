// DialogFragment.show() will take care of adding the fragment
// in a transaction.  We also want to remove any currently showing
// dialog, so make our own transaction and take care of that here.
FragmentTransaction ft = getFragmentManager().beginTransaction();
Fragment prev = getFragmentManager().findFragmentByTag("alertDialog");
if (prev != null) {
    ft.remove(prev);
}
ft.addToBackStack(null);

// Create and show the dialog.
newFragment.show(ft, "alertDialog");