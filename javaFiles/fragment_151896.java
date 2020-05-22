package extract.data;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExtractDataDynamic {
private static Scanner kb;

public static void main(String[] args) {
    // TODO Auto-generated method stub
    kb = new Scanner(System.in);
    String userpepseq;
    userpepseq = kb.nextLine();
    if (userpepseq.trim().isEmpty()){
        System.out.println("User didn't input any value!");
    } else {
        if (Pattern.matches("[a-zA-Z]+", userpepseq) == true) {
            WebDriver drivermassid = new FirefoxDriver();
            drivermassid.manage().window().maximize();
            drivermassid.get("http://exmaple.com/xyz_proxi.jsp#{\"searched_button\":\"datasets\",\"peptide\":\""+userpepseq+"\"}");
            //Here we are storing the value from the cell in to the string variable
            String sCellValuemassid = drivermassid.findElement(By.xpath(".//*[@class='result']/tbody")).getText();
            drivermassid.quit();
            if (sCellValuemassid.length() > 0){
                String mid="";
                String status="";
                Pattern pattern = Pattern.compile("MSV\\d+\\s+\\d+\\s+");
                Matcher macther= pattern.matcher(sCellValuemassid);
                while (macther.find()){
                    mid=((macther.group()).split("\\ "))[0];
                    status=((macther.group()).split("\\ "))[1];
                }
                if (meid.length() > 0 ){
                    WebDriver drivermasspro = new FirefoxDriver();
                    drivermasspro.manage().window().maximize();
                    drivermasspro.get("http://exmaple.com/xyz_proxi.jsp#{\"searched_button\":\"proteins\",\"peptide\":\""+userpepseq+"\"}");
                    String sCellValuemasspro = drivermasspro.findElement(By.xpath(".//*[@class='result']/tbody")).getText();
                    drivermasspro.quit();
                    if (sCellValuemasspro.length() > 0){
                        String [] proteinifo = sCellValuemasspro.split("\\n");
                        for (int i=0;i<proteinifo.length;i++) {
                            String [] subproteinifo = proteinifo[i].split("\\ ");
                            System.out.println(mid+" "+status+" "+subproteinifo[1]);
                        }
                    }
                } else {
                    System.out.println(" ID doesn't exist for "+userpepseq +".");
                }
            } else {
                System.out.println(userpepseq+" doesn't exist in database.");
            }


        } else {
            System.out.println(userpepseq+" should not contain any number!");
        }
    }