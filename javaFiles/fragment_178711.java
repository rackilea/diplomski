public class HomeFragment extends Fragment {
    private TextView counterText;
    private Button plusButton;
    private Button minusButton;
    private Button resetButton;
    private int counter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);

        counterText = view.findViewById(R.id.counterText);
        minusButton = view.findViewById(R.id.minusButton);
        minusButton.setOnClickListener(clickListener);
        plusButton = view.findViewById(R.id.plusButton);
        plusButton.setOnClickListener(clickListener);
        resetButton = view.findViewById(R.id.resetButton);
        resetButton.setOnClickListener(clickListener);

        initCounter();
        return  view;



    }

    private void initCounter() {
        counter = 0;
        counterText.setText(counter + "");
    }


    private void minusCounter() {
        counter--;
        counterText.setText(counter + "");
    }

    private void plusCounter() {
        counter++;
        counterText.setText(counter + "");
    }
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(@org.jetbrains.annotations.NotNull View view) {
            switch (view.getId()) {
                case R.id.minusButton:
                    minusCounter();
                    break;
                case R.id.plusButton:
                    plusCounter();
                    break;
                case R.id.resetButton:
                    initCounter();
                    break;
            }
        }
    };
    }