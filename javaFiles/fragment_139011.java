//In Main activity
public class MainActivity extends AppCompactActiity implements gotNewData{

//what ever

public void startThread(){
     myReceiveThread thread = new myReceiveThread(this);
     thread.start();
}

@Override
public void gotNewDataToDisplay(String data){
    someTextView.setText(data);
  }
}