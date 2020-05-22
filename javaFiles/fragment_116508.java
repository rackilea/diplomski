package org.nuttz.gsonTest;

import java.io.*;
import java.util.List;
import com.google.gson.*;

public class App 
{
    public static void main( String[] args )
    {
       Gson gson = new Gson();
       try {
          BufferedReader br = new BufferedReader(new FileReader("/home/jim/mondoconfig.json"));
          MondoConfig config = gson.fromJson(br, MondoConfig.class);
          System.out.println("Contents of config:");
          System.out.println(config.getMerchantURL());
          List<String> targets = config.targets;
          for (String t : targets) {
             System.out.println(t);
          }
       }
       catch (Exception x) {
          x.printStackTrace();
       }
    }
}