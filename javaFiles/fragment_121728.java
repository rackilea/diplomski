package com.test.rserve;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;


public class App {

    public static void main(String[] args) throws RserveException,
            REXPMismatchException {
        RConnection c = new RConnection();
        REXP x = c.eval("R.version.string");
        System.out.println(x.asString());   
    c.eval("library(GWmodel)");
    c.eval("data(LondonHP)");
    c.eval("DM <- gw.dist(dp.locat=coordinates(londonhp))");
    REXP y = c.eval("dim(DM)[1]");
    System.out.println(y.asString());
    c.close();
    }
}