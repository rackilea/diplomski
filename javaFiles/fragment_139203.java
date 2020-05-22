EditText billBeforeTipET;
   EditText tipAmountET;
   EditText finalBillET; 
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_crazy_tip_calc,
                container, false);
           billBeforeTipET = (EditText) rootView.findViewById(R.id.billEditText);
           tipAmountET = (EditText) rootView.findViewById(R.id.tipEditText);
           finalBillET = (EditText) rootView.findViewById(R.id.finalBillEditText);
           tipSeekBar = (SeekBar) rootView.findViewById(R.id.changeTipSeekBar);
        return rootView;
    }