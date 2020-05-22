HomeFragment fragment = new HomeFragment();
Bundle bundle = new Bundle();
bundle.putString("key", listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition));
fragment.setArguments(bundle);