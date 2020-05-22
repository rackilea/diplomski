import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class Nu {

    public static void main(String[] args) throws FileNotFoundException{
        int lineCount=0;
        Scanner scn1=new Scanner(new File("D:/abc.txt"));
        while(scn1.hasNextLine()){
            scn1.nextLine();
            lineCount++;//count no of lines for array length
        }
        int count=1;
        int cnt=0;
        String[] yearss=new String[lineCount];//new array for years
        Scanner scn=new Scanner(new File("D:/abc.txt"));
        while(scn.hasNextLine()){//file yearss array
            Scanner sc=new Scanner(scn.nextLine());
            while(sc.hasNext()){
                if(count==1){
                    sc.next();
                    count++;
                }
                else if(count==2){
                    yearss[cnt]=sc.next();//yearss array is filled
                    count++;
                }
                else{
                    sc.next();
                    count=count-2;
                }
            }
            cnt++;
        }

        TreeSet<String> yr=new TreeSet<String>();//remove duplicate elements from years and sort them
        for(int i=1;i<yearss.length;i++)
            if(yearss[i]!=null)
                yr.add(yearss[i]);//add elements to treeset
        TreeMap allRecord=new TreeMap();//treemap sorts keys
        try{
            File file=new File("D:/abc.txt");//used for file searching
            String[] yearArray=(String[])yr.toArray(new String[0]);//convert treeset to String array
            String roll="";
            String year="";
            String rank="";
            BufferedReader in =new BufferedReader(new FileReader(file));//Filereader reads character by character and bufferedReader reads blocks or streams of data
            String value=in.readLine();//read next line 

            while(value!=null){
                StringTokenizer st=new StringTokenizer(value);//pass line into stringtokenizer
                roll=st.nextToken();//add 1st string to roll
                year=st.nextToken();//add 2nd to year
                rank=st.nextToken();//add third to rank
                TreeMap record=(allRecord.get(roll)!=null)?(TreeMap)allRecord.get(roll):null;//if roll != null then add roll to record else add null
                //returns year and rank//   System.out.println(allRecord.get(roll));
                if(record==null)//if null
                    record=new TreeMap();//if null create new instance
                    else
                    allRecord.remove(roll);//remove null from allrecord
                record.put(year, rank);//put year and rank//every time record is refreshed 
                allRecord.put(roll, record);//put 22 and record//treemap returns null if get(key)==null
                value=in.readLine();//read next line
            }

            Set keyset=allRecord.keySet();//gets all  keys from allRecord
            Iterator i=keyset.iterator();//iterate keyset
            System.out.print("rno"+" ");
            for(int j=0;j<yearArray.length;j++)
                System.out.print(yearArray[j]+"   ");
            //print all years
            System.out.println();
            while(i.hasNext()){
                roll=(String)i.next();//get roll numbers
                if(!roll.equals("rno"))
                System.out.print(roll+"    ");
                else
                    System.out.print("    ");
                Map record=(Map)allRecord.get(roll);//get record using the rollno
                for(int j=0;j<yearArray.length;j++){
                    rank=(String)record.get(yearArray[j]);
                    //get rank for the year
                    if(rank!=null){
                    System.out.print(rank+"    ");
                    }
                    else
                    {
                        System.out.print("       ");
                    }
                }
                System.out.println("");
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
}*