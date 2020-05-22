package com.company.my;

public class MyTemplatingFunctions {
    public boolean doesNodeExist(String workspace, String id){
        if ( SessionUtil.getNodeByIdentifier(workspace, id) != null ){
            return true;
        }
        return false;
    }
}