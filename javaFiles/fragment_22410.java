public class MeanResult(){
private double meanR[]=new double[320];
private double meanG[]=new double[320];
private double meanB[]=new double[320];
//Maybe declare more stuff here

 public MeanResult(Bitmap image){
  //... code n stuff here to calculate width, height and pixel
 }
 public double getMeanR(){ return this.meanR[]; }
 public double getMeanG(){ return this.meanG[]; }
 public double getMeanB(){ return this.meanB[]; }
}