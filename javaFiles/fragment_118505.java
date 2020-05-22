CTelephony::TTelNumber telNumber(_L("+9001123456")); 
    CTelephony::TCallParamsV1 callParams;    
    callParams.iIdRestrict = CTelephony::ESendMyId;  
    CTelephony::TCallParamsV1Pckg callParamsPckg(callParams);  
    iTelephony->DialNewCall(iStatus, callParamsPckg, telNumber, iCallId);  
    SetActive();