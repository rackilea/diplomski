public void init(Context context){ 
    SensorTester st = new SensorTester(context);

    st.registerActivity(MainActivity.class);
    st.registerActivity(OtherActivity.class);
}