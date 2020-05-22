@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_player,
                container, false);
        mSeekBar = (SeekBar) rootView.findViewById(R.id.seekBar1);
        mSeekBar.setMax(mPlayer.getDuration());
        return rootView;
    }