FragmentTransaction ft = getFragmentManager().beginTransaction();
Fragment prev = getFragmentManager().findFragmentByTag("dialog");
if (prev != null) {
    ft.remove(prev);
}
ft.addToBackStack(null);
DialogFragment newFragment = new YourDialogFragment();
newFragment.show(ft, "dialog");