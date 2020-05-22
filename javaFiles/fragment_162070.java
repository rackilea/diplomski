@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ...

    View view;
    YouTubePlayerFragment youtubeFragment;

    if (convertView == null) {
        View temp = inflater.inflate(R.layout.custom_frag_youtube_list, parent, false);
        final int id = View.generateViewId();
        temp.setId(id);
        youtubeFragment = YouTubePlayerFragment.newInstance();
        activity.getFragmentManager()
                .beginTransaction()
                .replace(id, youtubeFragment)
                .commit();
        view = temp;
        view.setTag(youtubeFragment);
    } else {
        view = convertView;
        youtubeFragment = view.getTag();
    }


    // interact with youtubeFragment
    ...

    return view;
}