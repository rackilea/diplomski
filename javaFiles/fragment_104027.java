public class DecadeDotsFragment extends Fragment {
    ImageView dot_0, dot_1, dot_2, dot_3;
    View rootView;
    private int mPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.decade_dots_indicator_fragment, container, false);

        return rootView;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
       setData();
    }

    public void selectDot(int position){
        mPosition=position;
    }

    private void setData() {
        dot_0 = (ImageView) rootView.findViewById(R.id.dot_0);
        dot_1 = (ImageView) rootView.findViewById(R.id.dot_1);
        dot_2 = (ImageView) rootView.findViewById(R.id.dot_2);
        dot_3 = (ImageView) rootView.findViewById(R.id.dot_3);

        switch (mPosition){
            case 0:
                dot_0.setAlpha((float) 1);
                dot_1.setAlpha((float) 0.5);
                dot_2.setAlpha((float) 0.5);
                dot_3.setAlpha((float) 0.5);
                break;
            case 1:
                dot_0.setAlpha((float) 0.5);
                dot_1.setAlpha((float) 1);
                dot_2.setAlpha((float) 0.5);
                dot_3.setAlpha((float) 0.5);
                break;
            case 2:
                dot_0.setAlpha((float) 0.5);
                dot_1.setAlpha((float) 0.5);
                dot_2.setAlpha((float) 1);
                dot_3.setAlpha((float) 0.5);
                break;
            case 3:
                dot_0.setAlpha((float) 0.5);
                dot_1.setAlpha((float) 0.5);
                dot_2.setAlpha((float) 0.5);
                dot_3.setAlpha((float) 1);
                break;
            default:
                dot_0.setAlpha((float) 0.5);
                dot_1.setAlpha((float) 0.5);
                dot_2.setAlpha((float) 0.5);
                dot_3.setAlpha((float) 0.5);
        }

    }


}