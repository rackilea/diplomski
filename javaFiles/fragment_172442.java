public class CapteurActivity extends AppCompatActivity {
    static String lastStringReceived = "";
    StringBuffer buffer = new StringBuffer();
 ...
  public void onReceive(Context context, Intent intent){

            switch (intent.getAction()){
                //writes the data received in the EditText
                case BGXpressService.BGX_DATA_RECEIVED: {
                    String stringReceived = intent.getStringExtra("data");
                    if ( stringReceived != null ) {
                        if ( stringReceived.startsWith("[")) {
                            lastStringReceived = buffer.toString();
                            buffer = new StringBuffer();
                        }
                        buffer.append(stringReceived)
                    }

        ...
  }
 }
}