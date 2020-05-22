FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    View containerView = findViewById(R.id.mainView);
    ft.add(R.id.mainView, fragment);
    ft.commit();
    fm.executePendingTransactions();