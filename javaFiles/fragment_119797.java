package com.example.brandon.test;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;

public class AgentMgrService {
    private static final String TAG = "AgentMgrService";

    // load library
    static {
        System.loadLibrary("lib_agentmgr");
    }

    // C-function interface
    public native void startAgentMgr(String agentMgrConfig);
    public native void stopAgentMgr();

    public AgentMgrService(Context context) {

    }

    public void startMobileAgentMgr(String agentmgrConfig) throws RemoteException {
        startAgentMgr(agentmgrConfig);
    }

    public void testMe() {
        Log.d(TAG, "testMe!");
    }

    @Override
    public String toString() {
        Log.d(TAG, "This is a string!");
        return "This is a string!";
    }
}