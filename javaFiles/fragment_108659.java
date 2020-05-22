// Added this line to get the RelativeLayout I created in the xml to hold my view
        pasts_tests_holder = (RelativeLayout) findViewById(R.id.past_tests_holder)

        past_tests_label = (TextView) findViewById(R.id.past_tests_label);
        past_tests_label.setId(1);

        addViewForFirstTest();

    private void addViewForFirstTest() {

        past_test = new IndividualPastTests(this);
        RelativeLayout.LayoutParams past_test_view_params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        past_test.setGravity(Gravity.CENTER_HORIZONTAL);

        past_test_view_params.addRule(RelativeLayout.BELOW, past_tests_label.getId());

        past_test_view_params.height = 100;
        past_test_view_params.width = 600;

        past_test.setLayoutParams(past_test_view_params);       

        // Changed this line to add the past_test view to my new relative layout 
        past_tests_holder.addView(past_test);