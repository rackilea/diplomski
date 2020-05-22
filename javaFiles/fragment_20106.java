import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private EditText textBox;
    private int z , answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox=findViewById(R.id.editText);
        setActual();
    }

    // Top Part of your code from main method
    private void setActual(){
          Random random = new Random();

        int[] firstNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int x = firstNum[random.nextInt(firstNum.length)];/*Here program should put a random number out of firstNum array*/
        int[] secondNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int y = secondNum[random.nextInt(secondNum.length)];/*Here program should put a random number out of secondNum array*/
         z = x*y;
    }

    // Cheking part of your code
    public void onCheck(View view){

        this.answer = Integer.parseInt(textBox.getText().toString());

        if(answer == z){
            // Do action on right ans
            Log.d("TAG","Correct.");
        }
        else{
            // do action on wrong ans
            Log.d("TAG","Incorrect. Try again.");
        }


    }


}