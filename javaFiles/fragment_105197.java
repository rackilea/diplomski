public class Model {
 private String base;
 private String date;
 Rates RatesObject;


 // Getter Methods 

 public String getBase() {
  return base;
 }

 public String getDate() {
  return date;
 }

 public Rates getRates() {
  return RatesObject;
 }

 // Setter Methods 

 public void setBase(String base) {
  this.base = base;
 }

 public void setDate(String date) {
  this.date = date;
 }

 public void setRates(Rates ratesObject) {
  this.RatesObject = ratesObject;
 }
}


public class Rates {
 private float CAD;
 private float CHF;
 private float GBP;
 private float SEK;
 private float EUR;
 private float USD;


 // Getter Methods 

 public float getCAD() {
  return CAD;
 }

 public float getCHF() {
  return CHF;
 }

 public float getGBP() {
  return GBP;
 }

 public float getSEK() {
  return SEK;
 }

 public float getEUR() {
  return EUR;
 }

 public float getUSD() {
  return USD;
 }

 // Setter Methods 

 public void setCAD(float CAD) {
  this.CAD = CAD;
 }

 public void setCHF(float CHF) {
  this.CHF = CHF;
 }

 public void setGBP(float GBP) {
  this.GBP = GBP;
 }

 public void setSEK(float SEK) {
  this.SEK = SEK;
 }

 public void setEUR(float EUR) {
  this.EUR = EUR;
 }

 public void setUSD(float USD) {
  this.USD = USD;
 }
}