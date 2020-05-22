private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio0:
                // Write your code here
                break;
            case R.id.radio1:
                // Write your code here
                break;
            case R.id.radio2:
                // Write your code here
                break;
            case R.id.radio3:
                // Write your code here
                break;
            case R.id.radio4:
                // Write your code here
                break;
            case R.id.radio5:
                // Write your code here
                break;
            case R.id.radio6:
                // Write your code here
                break;
            default:
                break;
        }
    }
};

@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.meal_entry_fragment, container, false);
    rg = view.findViewById(R.id.group_no_1);
    rg.setOnCheckedChangeListener(onCheckedChangeListener);
    return view;
}