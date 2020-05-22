package java_r_dataframe;

import java.io.BufferedWriter;
import java.io.File;
 import java.io.FileWriter;
 import org.rosuda.REngine.REXP;
 import org.rosuda.REngine.REXPGenericVector;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
 import org.rosuda.REngine.Rserve.RserveException;

 public class mymainclass {

 public static void main(String[] args) throws RserveException,   REXPMismatchException {

RConnection c = new RConnection();

c.eval("source(\"/home/Jayshree/Desktop/return_data2.R\")");
 RList a  = c.eval("return_dataframe_2()").asList();


 REXPGenericVector v = new REXPGenericVector(a);

 c.eval("source(\"/home/Jayshree/Desktop/return_data2.R\")");
 c.assign("x", v);
  String b = c.eval("return_dataframe_3(x)").asString();

  System.out.println(b);
  }}