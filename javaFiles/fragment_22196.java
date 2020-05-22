Fragment fragment = null;
                fragment = new Menu1_1_Artikel();
                if (fragment != null) {
                    Bundle args = new Bundle();
                    args.putString("link", link);
                    fragment.setArguments(args);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }