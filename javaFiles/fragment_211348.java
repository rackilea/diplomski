package com.example.com.omegle.test;
import org.nikki.omegle.Omegle;
import org.nikki.omegle.core.OmegleException;
import org.nikki.omegle.core.OmegleMode;
import org.nikki.omegle.core.OmegleSession;
import org.nikki.omegle.event.OmegleEventAdaptor;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView txt;
    Button m_btn;
    EditText m_edt;
    OmegleSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_btn = (Button)findViewById(R.id.button);
        m_edt = (EditText)findViewById(R.id.type);
        m_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {




                        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ) {
                            new SendMsg().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                        } else {
                            new SendMsg().execute(m_edt.getText().toString());
                        }
                txt.append("You:"+m_edt.getText().toString()+"\n");
                m_edt.setText("");
                                    }
        });

        //OmegleChat om=new OmegleChat();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ) {
                    new OmegleChat().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                } else {
                    new OmegleChat().execute();
                }
            }
        });






    }


        protected void sendIt(View v) {
        txt.append("You: "+m_edt.getText().toString());
        m_edt.setText("");
    }

    private class SendMsg extends AsyncTask<String, Void, Void> {



        @Override
        protected void onPreExecute() {



        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }
        @Override

        protected Void doInBackground(String... param) {
            // TODO Auto-generated method stub
            //OmgeleChatOn();


            try {

                session.send(param[0]);


            } catch (OmegleException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }

         @Override
            protected void onPostExecute(Void result) {


         }
  }


        private class OmegleChat extends AsyncTask<Void, Void, Void> {



        @Override
        protected void onPreExecute() {

            txt=(TextView)findViewById(R.id.omegle);
            txt.append("Omegele Connection Started... \n");

        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }
        @Override

        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            OmgeleChatOn();
            return null;
        }

         @Override
            protected void onPostExecute(Void result) {


         }
  }

    public void OmgeleChatOn()
    {

        Omegle omegle = new Omegle();
        try {
            System.out.println("Opening session...");

             session = omegle.openSession(OmegleMode.NORMAL, new OmegleEventAdaptor() {

                @Override
                public void chatWaiting(OmegleSession session) {
                    System.out.println("Waiting for chat...");
                }


                @Override
                public void chatConnected(OmegleSession session) {
                    System.out
                            .println("You are now talking to a random stranger!");
                }

                @Override
                public void chatMessage(OmegleSession session, final String message) {
                    System.out.println("Stranger: " + message);
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            txt.append("Stranger:"+message+"\n");
                            m_btn.setClickable(true);
                        }
                    });

                }

                @Override
                public void messageSent(OmegleSession session, final String string) {
                    System.out.println("You: " + string);
                    /*runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            txt.append("You:"+string+"\n");
                        }
                    });  */
                }

                @Override
                public void strangerDisconnected(OmegleSession session) {
                    System.out.println("Stranger disconnected, goodbye!");
                    //System.exit(0);
                }

                @Override
                public void omegleError(OmegleSession session, String string) {
                    System.out.println("ERROR! " + string);
                    System.exit(1);
                }



            });



        } catch (OmegleException e) {
            e.printStackTrace();
        }



    }
}