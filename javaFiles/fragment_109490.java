@EActivity(R.layout.date_chooser)
public class DateChooser extends Activity {

    @Extra("SSID")
    String network;

    @ViewById(R.id.textView4)
    TextView textView;

    @AfterViews
    void init() {
        textView.setText(network);
        //some code   
    }

}