public void onStart() {
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    fragmentTransaction.add(R.layout.fragmentContainer, new MyFragment);
    fragmentTransaction.commit();
    fragmentManager.executePendingTransactions();

    foo(); // Should now work correctly
}