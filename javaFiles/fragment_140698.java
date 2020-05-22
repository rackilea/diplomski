private View paramView;

public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup 
container, @Nullable Bundle savedInstanceState) {

  paramView = inflater.inflate(R.layout.fragment_events, container, false);
  lineChartView = paramView.findViewById(R.id.chart);
  // Here comes all your code
  return paramView;
}