private void openList() {

        FragmentManager fragmentManager = getFragmentManager();

        ArticleListFragment fragmentList = (ArticleListFragment) fragmentManager.findFragmentByTag("Action_list");
        ArticleReaderFragment fragmentReader = (ArticleReaderFragment) fragmentManager.findFragmentByTag("Action_reader");

        if (fragmentList==null) {

            if (fragmentReader==null) {

                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.add(R.id.container_id, new ArticleListFragment(), "Action_list");
                //ft.addToBackStack(null);
                ft.commit();

            } else {

                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container_id, new ArticleListFragment(), "Action_list");
                //ft.addToBackStack(null);
                ft.commit();

            }
        }
        else {
            // fragment.update(...);
        }
    }