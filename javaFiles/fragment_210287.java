FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(containerId, fragment, tag);
     if (query != "") {
         transaction.addToBackStack(null);
     }
     transaction.commitAllowingStateLoss();