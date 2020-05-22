public class CrazyTipCalc extends Activity {

private static final String TOTAL_BILL = "TOTAL_BILL";
private static final String CURRENT_TIP = "CURRENT_TIP";
private static final String BILL_WITHOUT_TIP = "BILL_WITHOUT_TIP";

private double billBeforeTip; // Users bill before tip
private double tipAmount; // Tip amount
private double finalBill; // Bill plus Tip

EditText billBeforeTipET;
EditText tipAmountET;
EditText finalBillET;

private int[] checklistValues = new int[12]; 

CheckBox friendlyCheckBox;
CheckBox specialsCheckBox;
CheckBox opinionCheckBox;

RadioGroup availableRadioGroup;
RadioButton availableBadRadio;
RadioButton availableOKRadio;
RadioButton availableGoodRadio;

Spinner problemsSpinner;

Button startChronometerButton;
Button pauseChronometerButton;
Button resetChronometerButton;

Chronometer timeWaitingChronometer;

long secondsYouWaited = 0;

TextView timeWaitingTextView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_crazy_tip_calc); // Inflate the GUI

    if(savedInstanceState == null){

        // Just started

        billBeforeTip = 0.0;
        tipAmount = .15; 
        finalBill = 0.0; 

    } else {

        // App is being restored

        billBeforeTip = savedInstanceState.getDouble(BILL_WITHOUT_TIP);
        tipAmount = savedInstanceState.getDouble(CURRENT_TIP); 
        finalBill = savedInstanceState.getDouble(TOTAL_BILL); 

    }

    billBeforeTipET = (EditText) findViewById(R.id.billEditText); // Users bill before tip
    tipAmountET = (EditText) findViewById(R.id.tipEditText); // Tip amount
    finalBillET = (EditText) findViewById(R.id.finalBillEditText); // Bill plus tip

    tipSeekBar = (SeekBar) findViewById(R.id.changeTipSeekBar);

    tipSeekBar.setOnSeekBarChangeListener(tipSeekBarListener);

    billBeforeTipET.addTextChangedListener(billBeforeTipListener);

    friendlyCheckBox = (CheckBox) findViewById(R.id.friendlyCheckBox);
    specialsCheckBox = (CheckBox) findViewById(R.id.specialsCheckBox);
    opinionCheckBox = (CheckBox) findViewById(R.id.opinionCheckBox);

    setUpIntroCheckBoxes();
    availableBadRadio = (RadioButton) findViewById(R.id.availableBadRadio);
    availableOKRadio = (RadioButton) findViewById(R.id.availableOKRadio);
    availableGoodRadio = (RadioButton) findViewById(R.id.availableGoodRadio);
    availableRadioGroup = (RadioGroup) findViewById(R.id.availableRadioGroup);

    addChangeListenerToRadios();
    problemsSpinner = (Spinner) findViewById(R.id.problemsSpinner);

    problemsSpinner.setPrompt("Problem Solving");

    addItemSelectedListenerToSpinner();

    startChronometerButton = (Button) findViewById(R.id.startChronometerButton);
    pauseChronometerButton = (Button) findViewById(R.id.pauseChronometerButton);
    resetChronometerButton = (Button) findViewById(R.id.resetChronometerButton);

    setButtonOnClickListeners();

    timeWaitingChronometer = (Chronometer) findViewById(R.id.timeWaitingChronometer);

    timeWaitingTextView = (TextView) findViewById(R.id.timeWaitingTextView);

}   

private TextWatcher billBeforeTipListener = new TextWatcher(){

    @Override
    public void afterTextChanged(Editable arg0) {
    }

    @Override
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
            int arg3) {

    }

    @Override
    public void onTextChanged(CharSequence arg0, int arg1, int arg2,
            int arg3) {

        try{

            billBeforeTip = Double.parseDouble(arg0.toString());

        }

        catch(NumberFormatException e){

            billBeforeTip = 0.0;

        }

        updateTipAndFinalBill();

    }

};
private void updateTipAndFinalBill(){

    double tipAmount = Double.parseDouble(tipAmountET.getText().toString());

    double finalBill = billBeforeTip + (billBeforeTip * tipAmount);

    finalBillET.setText(String.format("%.02f", finalBill));

}

@Override
protected void onSaveInstanceState(Bundle outState){

    super.onSaveInstanceState(outState);

    outState.putDouble(TOTAL_BILL, finalBill);
    outState.putDouble(CURRENT_TIP, tipAmount);
    outState.putDouble(BILL_WITHOUT_TIP, billBeforeTip);

}

private SeekBar tipSeekBar;

private OnSeekBarChangeListener tipSeekBarListener = new OnSeekBarChangeListener(){

    @Override
    public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {


        tipAmount = (tipSeekBar.getProgress()) * .01;

        tipAmountET.setText(String.format("%.02f", tipAmount));

        updateTipAndFinalBill();

    }

    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar arg0) {
        // TODO Auto-generated method stub

    }

};


private void setUpIntroCheckBoxes(){

    friendlyCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

            checklistValues[0] = (friendlyCheckBox.isChecked())?4:0;

            setTipFromWaitressChecklist(); 

            updateTipAndFinalBill();

        }

    });

    specialsCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

            checklistValues[1] = (specialsCheckBox.isChecked())?1:0;

            setTipFromWaitressChecklist();      
            updateTipAndFinalBill();        
        }

    });     

    opinionCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

            checklistValues[2] = (opinionCheckBox.isChecked())?2:0;

            setTipFromWaitressChecklist();      
            updateTipAndFinalBill();

        }       
    });             
}
private void setTipFromWaitressChecklist(){

    int checklistTotal = 0;

    for(int item : checklistValues){

        checklistTotal += item;

    }

    tipAmountET.setText(String.format("%.02f", checklistTotal * .01));
}

private void addChangeListenerToRadios(){

    availableRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
    {

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            checklistValues[3] = (availableBadRadio.isChecked())?-1:0;
            checklistValues[4] = (availableOKRadio.isChecked())?2:0;
            checklistValues[5] = (availableGoodRadio.isChecked())?4:0;              
            setTipFromWaitressChecklist(); 
            updateTipAndFinalBill();                
        }
    });

}

private void addItemSelectedListenerToSpinner(){        
    problemsSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                int arg2, long arg3) {

            checklistValues[6] = (String.valueOf(problemsSpinner.getSelectedItem()).equals("Bad"))?-1:0;
            checklistValues[7] = (String.valueOf(problemsSpinner.getSelectedItem()).equals("OK"))?3:0;
            checklistValues[8] = (String.valueOf(problemsSpinner.getSelectedItem()).equals("Good"))?6:0;

            setTipFromWaitressChecklist();                      
            updateTipAndFinalBill();            
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }           
    });     
}

private void setButtonOnClickListeners(){   
    startChronometerButton.setOnClickListener(new OnClickListener(){
        @Override
        public void onClick(View arg0) {
            int stoppedMilliseconds = 0;

            String chronoText = timeWaitingChronometer.getText().toString();
            String array[] = chronoText.split(":");
            if (array.length == 2) {

              stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000
                    + Integer.parseInt(array[1]) * 1000;
            } else if (array.length == 3) {

              stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000 
                    + Integer.parseInt(array[1]) * 60 * 1000
                    + Integer.parseInt(array[2]) * 1000;
            }

            timeWaitingChronometer.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);

            secondsYouWaited = Long.parseLong(array[1]);

            updateTipBasedOnTimeWaited(secondsYouWaited);
            timeWaitingChronometer.start();             
        }                       
    });     
    pauseChronometerButton.setOnClickListener(new OnClickListener(){

        @Override
        public void onClick(View arg0) {
            timeWaitingChronometer.stop();              
        }                       
    });

    resetChronometerButton.setOnClickListener(new OnClickListener(){

        @Override
        public void onClick(View arg0) {

            timeWaitingChronometer.setBase(SystemClock.elapsedRealtime());
            secondsYouWaited = 0;
        }
    });
}

private void updateTipBasedOnTimeWaited(long secondsYouWaited){

    checklistValues[9] = (secondsYouWaited > 10)?-2:2;

    setTipFromWaitressChecklist(); 

    updateTipAndFinalBill();    
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.crazy_tip_calc, menu);
    return true;
}