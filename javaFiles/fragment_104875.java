import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.List;
import java.util.ArrayList;

/*
 * Just a class with three attributes with three properties. If you have 500 hundred rows
 * Each row can be represented as Object of ItemElements class, so 500 objects. 
 * Getters and setters are to allow access to the properties. 
 */
class ItemElements {
  String itemLine;
  String itemTime;
  String itemDescription;

  public String getItemLine() {
    return this.itemLine;
  }
  public String getItemTime() {
    return this.itemTime;
  }
  public String getItemDescription() {
    return this.itemDescription;
  }

  public void setItemLine(String itemLine) {
    this.itemLine = itemLine;
  }

  public void setItemTime (String itemTime) {
    this.itemTime = itemTime;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }
}
/* 
 * I have named the class as TestJSOUP, if you save this code as make sure that 
 * The below class name corresponds with the filename. Also make sure that you 
 * have the jsoup library in your path. 
 */
public class TestJSOUP {
        public static void main(String[] args) {
            String html = " <table cellspacing='1' cellpadding='0' rules='all' border='0' id='dtgHorasPorLinea' style='border-width:0px;width:100%;'><tr><td class='Minutes_css' align='center' valign='middle' style='height:45px;width:90px;'>26 <span style='font-size:16px'>min.</span></td><td class='Linea_Interurbana_Nocturna_css' valign='middle' style='height:45px;width:45px;'> <img id='dtgHorasPorLinea_ctl02_imgLineas' src='img/08_mobile_logo_interurb-n.jpg' style='border-width:0px;' /></td><td class='Linea_Interurbana_Nocturna_css' valign='middle' style='height:45px;width:95px;'><span id='dtgHorasPorLinea_ctl02_lblNumLine'>N802</span></td><td class='Descrip_td_sp' align='left' valign='middle' style='height:45px;width:944px;'>TORRES QUEVEDO-GUARDIA CIVIL TRÁFICO</td></tr><tr><td class='Minutes_css' align='center' valign='middle' style='height:45px;width:90px;'>02:15</td><td class='Linea_Interurbana_Nocturna_css' valign='middle' style='height:45px;width:45px;'><img id='dtgHorasPorLinea_ctl03_imgLineas' src='img/08_mobile_logo_interurb-n.jpg' style='border-width:0px;' /></td><td class='Linea_Interurbana_Nocturna_css' valign='middle' style='height:45px;width:95px;'><span id='dtgHorasPorLinea_ctl03_lblNumLine'>N804</span></td><td class='Descrip_td_sp' align='left' valign='middle' style='height:45px;width:944px;'>INTERCAMBIADOR DE ALUCHE</td></tr><tr><td class='Minutes_css' align='center' valign='middle' style='height:45px;width:90px;'>02:37</td><td class='Linea_Interurbana_Nocturna_css' valign='middle' style='height:45px;width:45px;'><img id='dtgHorasPorLinea_ctl04_imgLineas' src='img/08_mobile_logo_interurb-n.jpg' style='border-width:0px;' /> </td><td class='Linea_Interurbana_Nocturna_css' valign='middle' style='height:45px;width:95px;'><span id='dtgHorasPorLinea_ctl04_lblNumLine'>N802</span></td><td class='Descrip_td_sp' align='left' valign='middle' style='height:45px;width:944px;'>TORRES QUEVEDO-GUARDIA CIVIL TRÁFICO</td></tr><tr> <td class='Minutes_css' align='center' valign='middle' style='height:45px;width:90px;'>04:15</td><td class='Linea_Interurbana_Nocturna_css' valign='middle' style='height:45px;width:45px;'><img id='dtgHorasPorLinea_ctl05_imgLineas' src='img/08_mobile_logo_interurb-n.jpg' style='border-width:0px;' /></td><td class='Linea_Interurbana_Nocturna_css' valign='middle' style='height:45px;width:95px;'><span id='dtgHorasPorLinea_ctl05_lblNumLine'>N804</span></td><td class='Descrip_td_sp' align='left' valign='middle' style='height:45px;width:944px;'>INTERCAMBIADOR DE ALUCHE</td></tr></table>";

/* 
 * Document parses the html 
 */         
Document doc = Jsoup.parse(html);
                    //retrieve all elements having the class "Minutes_css" 
                    Elements tdMinutes  = doc.getElementsByClass("Minutes_css");
                    //retrieves all elements having class as Descript_td_sp 
                            Elements tdDescription = doc.getElementsByClass("Descrip_td_sp");
                                          //retrieves span within second td element of each tr 
                                            Elements tdLines = doc.select("tr td:eq(2) span");

                                                            //This loop is for testing purpose 
                                                            for(Element line: tdLines) {
                                                                        System.out.println("Element line is: " + line.text());
                                                                                    }
                                                                                                    //these lines are to verify that you have got the correct number of elements 
                                                                                                    System.out.println("tdMinutes size: " + tdMinutes.size());
                                                                                                            System.out.println("tdDescription size: " + tdDescription.size());
                                                                                                                    System.out.println("tdLine size: " + tdLines.size());

//These foreach loops are also for testing purpose, shows you what the jsoup captured
for(Element e: tdMinutes) {
System.out.println("tdMinute is: " + e.text());
}

for(Element e: tdDescription) {
System.out.println("tdDescription: " + e.text());
}

/*
 * This is a list of ItemsElements, meaning it stores more than one ItemsElement where 
 * each ItemsElemen stores the three values of your choice
 */
List<ItemElements> allItemElements = new ArrayList<ItemElements>();

/*
 * The following Loop iterates through captured elements using jsoup and use them to 
 * construct an instance of ItemsElement and then at the end of the loop round
 * It adds the constructed ItemsElement object to the list 
 */
for(int i=0; i<tdMinutes.size(); i++) {
    ItemElements e = new ItemElements();
    e.setItemLine(tdLines.get(i).text());
    e.setItemTime(tdMinutes.get(i).text());
    e.setItemDescription(tdDescription.get(i).text());

    allItemElements.add(e);
}


System.out.println("############## all ItemElements size: \n");

/*
 * The following loops through the List ItemsElements list and print their 
 * values for you. 
*/
int counter = 0;
for(ItemElements element: allItemElements) {
   System.out.println(counter + "# \n");
   System.out.println("Item line: " + element.getItemLine());
   System.out.println("Item time: " + element.getItemTime());
   System.out.println("Item Description: " + element.getItemDescription());
   i++; 
}                                                                                       }
                                                                                                                        }