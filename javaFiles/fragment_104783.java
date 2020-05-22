String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "thursday","Sunday"}

    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.custom_app_bar_spinner);

    Spinner spinner = (Spinner) findViewById(R.id.spinnerMethodInterviews);
    Spinner spinnerSecond = (Spinner) findViewById(R.id.spinnerMethodSecond);
    ArrayAdapter<String>   spinnerAdapter = new ArrayAdapter(this,
            R.layout.custom_title, android.R.id.text1, weeks);

    spinnerAdapter.setDropDownViewResource(R.layout.cutom_spinner);
    spinner.setAdapter(spinnerAdapter);
    spinnerSecond.setAdapter(spinnerAdapter);
    spinner.setOnItemSelectedListener(this);
    spinnerSecond.setOnItemSelectedListener(this);