Fragment videoFragment = new VideoPlayerFragment();
Fragment videoFragment2 = new VideoPlayerFragment2();
FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
transaction.add(R.id.video_fragment, videoFragment);
transaction.add(R.id.video_fragment2, videoFragment2);
transaction.commit()