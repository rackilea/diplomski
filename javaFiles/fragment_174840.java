package com.sg2net.test;

public class TestCast {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestCast tc= new TestCast();
        tc.funcEval();
    }

    public double funcEval(){
        return ((Long) eval()).doubleValue();
    }   

    private Object eval() {
        return new Long(1);
    }

}