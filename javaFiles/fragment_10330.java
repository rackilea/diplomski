@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        id = getArguments().getInt("ID");
        vehicle = getArguments().getString("ITEM");
        vehicle_info = getArguments().getStringArray("ITEM_INFO");

        changedImagePosition = ((MainActivity)getActivity()).getChangedImagePosition(id);
        View view = inflater.inflate(R.layout.task_fragment,container,false);
        TextView messageTextView = (TextView) view.findViewById(R.id.textView);
        messageTextView.setText(vehicle);

        imageViewPager = (ViewPager)view.findViewById(R.id.imageViewPager);
        imagePagerAdapter = new ImagePagerAdapter(getActivity(), vehicle_info);
        imageViewPager.setAdapter(imagePagerAdapter);

        /*The below code doesn't work
        if (imageViewPager.getCurrentItem() != changedImagePosition) {

            Log.i("POSITION current", ":" + imageViewPager.getCurrentItem());
            Log.i("POSITION changed", " :"+ changedImagePosition);

            setCurrentItem = true;
            imageViewPager.setCurrentItem(changedImagePosition, false);
            Log.i("POSITION getCurrent", " :" + imageViewPager.getCurrentItem());
        }
        */


        new Handler().postAtTime(new Runnable() {
            @Override
            public void run() {
                if (imageViewPager.getAdapter() != null) {
                    imageViewPager.getAdapter().notifyDataSetChanged();
                    imageViewPager.setCurrentItem(changedImagePosition);
                }
            }
        },0);

        return view;
    }
`