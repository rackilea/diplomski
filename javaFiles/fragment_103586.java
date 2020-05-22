LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(R.layout.ingamepopup,null); //This is the view that has to be referenced.

            mainLayout = (LinearLayout) view.findViewById(R.id.llScoreChange); 
//notice view.findViewById(...)
            customButtonLayout = (LinearLayout)  view.findViewById(R.id.llCustomButtonsScoreChange);
            plus = (ImageButton)  view.findViewById(R.id.ibPlusPU);
            minus = (ImageButton)  view.findViewById(R.id.ibMinusPU);
            cancel = (ImageButton)  view.findViewById(R.id.ibCancelPU);
            cb1 = (Button)  view.findViewById(R.id.bCustom1PU);
            cb2 = (Button)  view.findViewById(R.id.bCustom2PU);
            cb3 = (Button)  view.findViewById(R.id.bCustom3PU);
            score = (EditText)  view.findViewById(R.id.etScoreChange);

            if(getPrefs.getBoolean("custom button checked"+gameNum, false)){
                customButtonLayout.setVisibility(View.VISIBLE);

                cb1.setText(Float.toString(getPrefs.getFloat("button 1 value"+gameNum,1)));
                cb2.setText(Float.toString(getPrefs.getFloat("button 2 value"+gameNum,5)));
                cb3.setText(Float.toString(getPrefs.getFloat("button 3 value"+gameNum,10)));
            } else{
                customButtonLayout.setVisibility(View.GONE);
            }

            scoreChangeDialog = new AlertDialog.Builder(this)
            .setTitle("Score change")
            .setView(view)
            .create();

            return scoreChangeDialog;
        }