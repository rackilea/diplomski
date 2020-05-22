private void onStream(boolean start) {

    ClientThreadStates State = mClientThread.GetState();
    synchronized(State) {
        if (start)  {
            mClientThread.SetState(ClientThreadStates.eSendToServer);
        }
        else        {
            mClientThread.SetState(ClientThreadStates.eReadFromServer);
        }
        try {               
            State.notify();
        }
        catch( IllegalMonitorStateException  e ) {
                Log.e(LOG_TAG, "Got Exception @ notify <==", e);
        }        
    }
 }//onStream

}//StreamingProjectActivity