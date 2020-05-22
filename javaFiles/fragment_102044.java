public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
 { 
      // Inflate the layout for this fragment      
      View root = inflater.inflate(R.layout.fragment_preferences, container, false); 
      final SeekBar s1 = (SeekBar) root.findViewById(R.id.s1Bar); 
      final TextView spicinessText = (TextView) root.findViewById(R.id.spicinessTxt); 
      s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() 
      {
           @Override 
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) 
           {
                 Toast.makeText(getContext(), String.valueOf(i), Toast.LENGTH_SHORT).show(); 
                spicinessText.setText("Spiciness " + String.valueOf(i)); 
           } 
           @Override 
           public void onStartTrackingTouch(SeekBar seekBar) 
           { } 
           @Override 
           public void onStopTrackingTouch(SeekBar seekBar) 
          { } 
      }); 
     return root;
  }