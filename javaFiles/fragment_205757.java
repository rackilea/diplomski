Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_content, fragment).commit();
                    menuItem.setChecked(true);
                    setTitle(menuItem.getTitle());

                }
            }, 1000);