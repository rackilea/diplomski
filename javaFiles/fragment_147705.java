package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


class Pass {    
    private int identity;
    private ArrayList<Date> logged_in;
    private ArrayList<Date> logged_out;
    public Pass(int identity){ 
        this.identity = identity;
        this.logged_in = new ArrayList<Date>();
        this.logged_out = new ArrayList<Date>();
    }    
}

class Officer {    
    private Pass pass;
    public Officer(Pass pass){ this.pass = pass; }    
}    

public class test{
    public static void main(String[] args) throws ParseException {  
        Officer officer1 = new Officer(new Pass(1111));// PROBLEM IN THIS LINE 
    }
}