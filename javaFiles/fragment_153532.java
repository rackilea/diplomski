Deque<Integer> mStack = new ArrayDeque<>();
    boolean isBackPressed  = false;

    private void setBottomNavigationView() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                         if(!isBackPressed) {
                           pushFragmentIntoStack(R.id.ic_home);
                       }
                        isBackPressed = false
                        setFragment(HomeFragment.newInstance(), HOME_FRAGMENT);
                        return true;
                    case R.id.ic_search:
                        if(!isBackPressed) {
                           pushFragmentIntoStack(R.id.ic_search);
                       }
                        isBackPressed = false
                        setFragment(SearchFragment.newInstance(), SEARCH_FRAGMENT);
                        return true;
                    case R.id.ic_circle:
                        if(!isBackPressed) {
                           pushFragmentIntoStack(R.id.ic_circle);
                       }
                        isBackPressed = false
                        setFragment(ShareFragment.newInstance(), SHARE_FRAGMENT);
                        return true;

                    default:
                        return false;
                }
            }
        });
        mBottomNavigationView.setOnNavigationItemReselectedListener(new 
              BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

            }
        });
     mBottomNavigationView.setSelectedItemId(R.id.ic_home);
     pushFragmentIntoStack(R.id.ic_home);
    }

    private void pushFragmentIntoStack(int id)
    {
        if(mStack.size() < 3)
        {
            mStack.push(id);
        }
        else
        {
            mStack.removeLast();
            mStack.push(id);
        }
    }

    private void setFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(mStack.size() > 1)
        {
            isBackPressed = true;
            mStack.pop();
            mBottomNavigationView.setSelectedItemId(mStack.peek());
        }
        else 
        {
            super.onBackPressed();
        }
    }