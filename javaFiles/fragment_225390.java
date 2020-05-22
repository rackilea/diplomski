setContentView(R.layout.activity_main);

TextView numerator = (TextView) findViewById(R.id.firstBox);
TextView fractionBar = (TextView) findViewById(R.id.secondBox);
TextView denominator = (TextView) findViewById(R.id.thirdBox);

fractionBar.setWidth(denominator.getWidth());