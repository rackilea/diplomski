enum ClientThreadStates {
eUndefined,
eStopped,
eRunning,
eIdle,
eSendToServer,
eReadFromServer
}

public class ClientThread extends Thread {

private UDPClient mClient= null;
private ClientThreadStates mStateOfTheThread = ClientThreadStates.eUndefined;
private static String mLOG_TAG; 

public ClientThread(String s){

    mLOG_TAG = s;
    mStateOfTheThread = ClientThreadStates.eStopped;
    mClient = new UDPClient(s);
    start();
}//constructor

public void SetState(ClientThreadStates paramState) {

    mStateOfTheThread = paramState;
}

public ClientThreadStates GetState() {

    return mStateOfTheThread;
}
private void Action(ClientThreadStates s) {

    synchronized(s) {

        switch(mStateOfTheThread)   {

        case eRunning: //fall
        case eIdle: break;
        case eSendToServer: mClient.SendDataToServer(); break;
        case eReadFromServer: mClient.ReceiveDataFromServer(); break;

        }
        try {
            mStateOfTheThread.wait();
        }
        catch( InterruptedException e ){
            Log.e(mLOG_TAG, "Got Exception at wait <==", e);
        }           

    }
}

public void run() {
    mStateOfTheThread = ClientThreadStates.eRunning;
    System.out.println("In Thread.run .. The State is " + mStateOfTheThread);
    while(ClientThreadStates.eStopped.compareTo(mStateOfTheThread) < 0){ //state >stopped

        Action(mStateOfTheThread);
    }//while

}//run
}//class ClientThread