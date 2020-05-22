Fragment detail = new DetailFragment();
Bundle arg = new Bundle();
arg.putStringArrayList("lp", li);
detail.setArguments(arg);
FragmentManager fragmentManager = getFragmentManager();
fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();