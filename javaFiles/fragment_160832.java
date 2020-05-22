package com.androidbook.droid1;
import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
public class DroidActivity3 extends Activity
{
public static class GetThreeRandomIntClass
{
    public static class Dots 
    { 
        public int a; 
        public int b; 
        public int c; 

        public Dots()
        {
                a = 0;
                b = 0;
                c = 0;
        }

        @Override
        public String toString()
        {
            return "[" + a + "]" + "[" + b + "]" + "[" + c + "]";
        }
    }

    public static void getThreeRandomInt(Dots d)
    {
        int[] arr = new int[100];
        Random r = new Random();
        for(int i=0; i<arr.length ; i++){
            arr[i] = i + 1;
        }
        int randInt = r.nextInt(100);
        d.a = arr[randInt];
        for(int i=randInt; i<arr.length - 1 ; i++){
            arr[i] = arr[i + 1];
        }
        randInt = r.nextInt(99);
        d.b = arr[randInt];
        for(int i=randInt; i<arr.length - 2 ; i++){
            arr[i] = arr[i + 1];
        }
        randInt = r.nextInt(98);
        d.c = arr[randInt];
    }
}




@Override
protected void onCreate(Bundle savedInstanceState)
{

    this.setContentView(R.layout.third);

    GetThreeRandomIntClass.Dots d = new GetThreeRandomIntClass.Dots();
    GetThreeRandomIntClass.getThreeRandomInt(d);

    TextView textView1 = (TextView) this.findViewById(R.id.textView1);
    textView1.setText(String.valueOf(d.a));

    TextView textView2 = (TextView) this.findViewById(R.id.textView2);
    textView2.setText(String.valueOf(d.b));

    TextView textView3 = (TextView) this.findViewById(R.id.textView3);
    textView3.setText(String.valueOf(d.c));

    super.onCreate(savedInstanceState);
}}