Fragment send2 = new Send2();
            FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.send1frameLayoutId, send2);

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();