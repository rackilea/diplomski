package org.nuttz.gsonTest;
import java.util.ArrayList;

public class MondoConfig {
   private String merchantURL;
   public ArrayList<String> targets = new ArrayList<String>();

   MondoConfig () {}

   public String getMerchantURL() {
      return this.merchantURL;
   }

   public void setMerchantURL(String url) {
      this.merchantURL = url;
   }

   public ArrayList<String> getTargets() {
      return this.targets;
   }

   public void setTargets(ArrayList<String> t) {
      this.targets = t;
   }
}