package com.example.josue.login;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView diezmob;

    public static final String nombres = "names";
    TextView txtBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtBienvenido = (TextView) findViewById(R.id.txtbienvenido);
        String usuario = getIntent().getStringExtra("names");
        txtBienvenido.setText("¡Bienvenido(a) Hermano(a) " + usuario + "!");

        diezmob = (TextView) findViewById(R.id.txtdiezmob);

        findViewById(R.id.btncalcular).setOnClickListener(this);
        findViewById(R.id.btncalcular5).setOnClickListener(this);
        findViewById(R.id.btncalcular10).setOnClickListener(this);
        findViewById(R.id.btncalcular15).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btncalcular:

                double cinco, cien, doscientos, quinientos, mil, dosmil, cincomil, diezmil, veintemil, cincuentamil, cienmil;

                String Cinco = ((EditText) findViewById(R.id.txt50)).getText().toString();
                String Cien = ((EditText) findViewById(R.id.txt100)).getText().toString();
                String Doscientos = ((EditText) findViewById(R.id.txt200)).getText().toString();
                String Quinientos = ((EditText) findViewById(R.id.txt500)).getText().toString();
                String Mil = ((EditText) findViewById(R.id.txt1000)).getText().toString();
                String Dosmil = ((EditText) findViewById(R.id.txt2000)).getText().toString();
                String Cincomil = ((EditText) findViewById(R.id.txt5000)).getText().toString();
                String Diezmil = ((EditText) findViewById(R.id.txt10000)).getText().toString();
                String Veintemil = ((EditText) findViewById(R.id.txt20000)).getText().toString();
                String Cincuentamil = ((EditText) findViewById(R.id.txt50000)).getText().toString();
                String Cienmil = ((EditText) findViewById(R.id.txt100000)).getText().toString();

                if (Cinco != null && !Cinco.equals("")) {
                    cinco =  Double.valueOf(Cinco);

                }else{
                    cinco = 0;

                }

                if (Cien != null && !Cien.equals("")){
                    cien =   Double.valueOf(Cien);

                }else{
                    cien=0;

                }

                if (Doscientos != null && !Doscientos.equals("")) {
                    doscientos =  Double.valueOf(Doscientos);

                }else{
                    doscientos=0;

                }

                if (Quinientos != null && !Quinientos.equals("")) {
                    quinientos = Double.valueOf(Quinientos);

                }else{
                    quinientos = 0;

                }
                if (Mil != null && !Mil.equals("")){
                    mil = Double.valueOf(Mil);

                }else{
                    mil = 0;

                }
                if (Dosmil != null && !Dosmil.equals("")) {
                    dosmil = Double.valueOf(Dosmil);

                }else {
                    dosmil = 0;

                }
                if (Cincomil != null && !Cincomil.equals("")) {
                    cincomil = Double.parseDouble(Cincomil);

                }else {
                    cincomil = 0;

                }
                if (Diezmil !=null && !Diezmil.equals("")) {
                    diezmil = Double.valueOf(Diezmil);

                }else {
                    diezmil = 0;

                }

                if (Veintemil != null && !Veintemil.equals("")) {
                    veintemil = Double.valueOf(Veintemil);

                }else {
                    veintemil = 0;

                }

                if (Cincuentamil != null && !Cincuentamil.equals("") ) {
                    cincuentamil = Double.valueOf(Cincuentamil);

                }else {
                    cincuentamil = 0;

                }

                if (Cienmil != null && !Cienmil.equals("")    ) {
                    cienmil = Double.valueOf(Cienmil);

                }else {
                    cienmil = 0;

                }



                double suma = (cinco * 50) + (cien * 100) + (doscientos * 200) + (quinientos * 500) + (mil * 1000) +
                            (dosmil * 2000) + (cincomil * 5000) + (diezmil * 10000) + (veintemil * 20000) + (cincuentamil * 50000) +
                            (cienmil * 100000);
                    String resultado = String.valueOf((int)(suma));
                    diezmob.setText(String.valueOf(resultado));

                break;

            case R.id.btncalcular5:

                Intent i = new Intent(this, Main5Activity.class);
                i.putExtra("dato",diezmob.getText().toString());
                startActivity(i);

                break;

            case R.id.btncalcular10:
                Intent ii = new Intent(this, Main5Activity.class);
                startActivity(ii);
                break;

            case
                    R.id.btncalcular15:
                Intent iii = new Intent(this, Main5Activity.class);
                startActivity(iii);
                break;

            default:
                break;
        }
    }
}