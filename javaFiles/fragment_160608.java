package pkg;


import java.io.*;
import java.util.*;


public class pkg
{
public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub

    String[] array = {
            "FRAMae Berenice MEITE         455.455",
            "CHNKexin ZHANG                454.584",
            "UKRNatalia POPOVA             453.443",
            "GERNathalie WEINZIERL         452.162",
            "RUSEvgeny PLYUSHCHENKO        191.399",
            "CANPatrick CHAN               189.718",
            "CHNHan YAN                    185.527",
            "CHNCheng & Hao                271.018",
            "ITAStefania & Ondrej          270.317",
            "USAMarissa & Simon            264.256",
            "GERMaylin & Daniel            260.825",
            "FRAFlorent AMODIO             179.936",
            "GERPeter LIEBERS              179.615"};
    String[] info = new String [13];
    String[] stats = new String[13];    
    String[] team = new String[13];




            //Splitting up Info/ Score into two arrays

            for (int j =0; j< 13; j++){
                team[j] = array[j].substring (0, 3).trim ();
                info[j] = array[j].substring (3, 30).trim ();
                stats[j] = array[j].substring (36).trim ();
            }



            double[] statsDub = new double[13];
            for (int k =1; k < 13; k++){
            statsDub[k] = Double.parseDouble(stats[k]);
            }
            Map<String,Double> totalScore = new HashMap<>();
            for (int j =0; j< 13; j++){

                  Double tmp = totalScore.get (team[j]);
                    if (tmp != null)
                    {
                        totalScore.put(team[j], statsDub[j]+tmp);
                    }
                    else
                            totalScore.put(team[j], statsDub[j]);




            }
             // Get a set of the entries
              Set set = totalScore.entrySet();
              // Get an iterator
              Iterator i1 = set.iterator();
              // Display elements
              while(i1.hasNext()) {
                 Map.Entry me = (Map.Entry)i1.next();
                 System.out.print(me.getKey() + ": ");
                 System.out.println(me.getValue());
              }
}
}