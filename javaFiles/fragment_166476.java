btn= view.findViewById(R.id.btn_in_xml);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager() ;
                fragmentFragment formFragment;

                Fragment retainedFragment = fm.findFragmentByTag(FORM_FRAGMENT_KEY);
                if (retainedFragment != null && retainedFragment instanceof childFragment) {
                    formFragment = (childFragment) retainedFragment;
                } else {
                    formFragment = new childFragment();
                    fm.beginTransaction()
                            .replace(R.id.flContent, formFragment, FORM_FRAGMENT_KEY)
                            .commit();
                }


            }
        });