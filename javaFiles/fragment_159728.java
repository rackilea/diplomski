import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


import com.config.PropertyConfiguration;
import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.mt3xx.MT300;
import com.prowidesoftware.swift.model.mt.mt3xx.MT300.SequenceA;
import com.prowidesoftware.swift.model.mt.mt3xx.MT300.SequenceB;
import com.prowidesoftware.swift.model.mt.mt3xx.MT300.SequenceB1;
import com.prowidesoftware.swift.model.mt.mt3xx.MT300.SequenceB2;
import com.prowidesoftware.swift.model.mt.mt3xx.MT320;
import com.prowidesoftware.swift.model.mt.mt3xx.MT320.SequenceC;
import com.prowidesoftware.swift.model.mt.mt3xx.MT320.SequenceD;
import com.prowidesoftware.swift.model.mt.mt6xx.MT600;



public class SwiftParsering {
    public static final String BLOCK_START_REG_EXP = "\\{1:";
    private static final String BLOCK_START = "{1:";

    public static void main(String as[]){
    SwiftParsering swift=new SwiftParsering();
    swift.fileProcess(new File("D:\\swift\\msg\\"));
    }
public void fileProcess(File file){
    File[] fileList=file.listFiles();
    appProps=new PropertyConfiguration().getAllProperties();
    for(int i=0;i<fileList.length;i++){

        if(fileList[i].isFile()){
            File file2 = fileList[i];

                parse(file2);

        }


        else if (fileList[i].isDirectory()) {

            fileProcess(fileList[i]);
        }
}
}


    public void parse(File mt950FolderLocation) {



        System.out.println("welcome");

        SwiftParser swiftMsgParser = null;

        try {

            swiftMsgParser = new SwiftParser();



            BufferedReader br = null;


                    try {
                        String currentLine = "";
                        StringBuilder mtMessage = new StringBuilder();
                        List<StringBuilder> messageList = new ArrayList<StringBuilder>();
                        br = new BufferedReader(new FileReader(mt950FolderLocation));

                        while ((currentLine = br.readLine()) != null) {

                            currentLine = currentLine + "\n";

                            if (currentLine.contains(BLOCK_START)) {
                                if(currentLine.startsWith(BLOCK_START)){
                                    String[] str = currentLine.split(BLOCK_START_REG_EXP);

                                    for (int index = 1; index < str.length; index++) {
                                        String token = str[index];
                                        if (index == 1) {
                                            mtMessage.append(token);
                                            messageList.add(mtMessage);
                                            mtMessage = new StringBuilder();
                                        } else if (index == (str.length - 1) || index==1) {
                                            mtMessage = new StringBuilder();
                                            mtMessage.append(BLOCK_START).append(token);
                                            //messageList.add(mtMessage);

                                        } else {

                                            mtMessage = new StringBuilder();
                                            mtMessage.append(BLOCK_START).append(token);
                                            messageList.add(mtMessage);

                                        }
                                    }

                                }else{
                                    String[] str = currentLine.split(BLOCK_START_REG_EXP);

                                    for (int i = 0; i < str.length; i++) {
                                        String token = str[i];
                                        if (i == 0) {
                                            mtMessage.append(token);
                                            messageList.add(mtMessage);
                                            mtMessage = new StringBuilder();
                                        } else if (i == (str.length - 1) || i==1) {
                                            mtMessage = new StringBuilder();
                                            mtMessage.append(BLOCK_START).append(token);
                                            //messageList.add(mtMessage);

                                        } else {

                                            mtMessage = new StringBuilder();
                                            mtMessage.append(BLOCK_START).append(token);
                                            messageList.add(mtMessage);

                                        }
                                    }
                                }

                                //mtMessage.append(currentLine);

                            } else {

                                mtMessage = mtMessage.append(currentLine);
                            }
                        }
                    Swift320Parser parser320=new Swift320Parser();
                    MT300Parser mt300=new MT300Parser();
                    MT600Parser mt600=new MT600Parser();
                        for (StringBuilder messageBuilder : messageList) {
                            if (messageBuilder != null) {

                                swiftMsgParser.setReader(new StringReader(messageBuilder.toString()));
                                SwiftMessage msg = swiftMsgParser.message();
                            try{    
                            if(msg.getType().equals("300")){
                                mt300.Mt300Parser(msg,mt950FolderLocation.getName());
                            }else if(msg.getType().equals("320")){
                                parser320.Mt320Parser(msg,mt950FolderLocation.getName());
                            }
                            else if(msg.getType().equals("600")){
                                mt600.Mt600Parser(msg,mt950FolderLocation.getName());
                            }
                            }catch(Exception e){}
                            msg=null;       
                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {

                        try {
                            //System.out.println(count);
                            br.close();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        File file2 = new File(appProps.getProperty("PROCESS_PATH") + mt950FolderLocation.getParentFile().getName());
                        boolean is=file2.exists();
                        Path movefrom = FileSystems.getDefault().getPath(mt950FolderLocation.getPath());
                        Path target = FileSystems.getDefault().getPath(file2.getPath()+"\\" + mt950FolderLocation.getName() );
                        Path duplicate = FileSystems.getDefault().getPath(file2.getPath() + "\\" + mt950FolderLocation.getName());
                        boolean check = new File(file2, mt950FolderLocation.getName()).exists();
                        try{
                        if (check) {

                        Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
                        } else {
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
                        }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                //}

            //}
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }


}


==================Class MT300===========================================

public class MT300Parser {
    public void Mt300Parser(SwiftMessage msg,String fileName){

        Map<String,Object>data=new HashMap<String,Object>();
        if(msg!=null){
            MT300 mt=new MT300(msg);
                if(mt!=null){
        SequenceA seqA= mt.getSequenceA();
        data.put("OPERATION_TYPE", seqA!=null?seqA.getTagValue("22A"):null);
        data.put("PARTYB", seqA!=null?seqA.getTagValue("87A"):null);
        data.put("PARTYA", seqA!=null?seqA.getTagValue("82A"):null);
        data.put("SENDER_REFERENCE", seqA!=null?seqA.getTagValue("20"):null);
        data.put("RELATED_REFERENCE", seqA!=null?seqA.getTagValue("21"):null);
        data.put("COMMON_REFERENCE", seqA!=null?seqA.getTagValue("22C"):null);

        SequenceB seqB= mt.getSequenceB();

        data.put("VALUE_DATE", seqB!=null?seqB.getTagValue("30V"):null);
        data.put("EXCHANGE_RATE", seqB!=null?seqB.getTagValue("36").replace(",","."):null);
        data.put("TRADE_DATE", seqB!=null?seqB.getTagValue("30T"):null);


        SequenceB1 seqB1=   mt.getSequenceB1();

        data.put("RECEIVING_AGENT1", seqB1!=null?seqB1.getTagValue("57A"):null);
    String str=seqB1!=null?seqB1.getTagValue("32B"):null;
    data.put("AMOUNT_BOUGTH", str!=null?str.substring(3).replace(",", "."):0.0);
    data.put("CURRENCY_BOUGHT", str!=null?str.substring(0,3):null);


    SequenceB2 seqB2=   mt.getSequenceB2();

    data.put("RECEIVING_AGENT2", seqB2!=null?seqB2.getTagValue("57A"):null);
    String str2=seqB2!=null?seqB2.getTagValue("33B"):null;
    data.put("AMOUNT_SOLD", str2!=null?str2.substring(3).replace(",", "."):0.0);
    data.put("CURRENCY_SOLD", str2!=null?str2.substring(0,3):null);

        data.put("DELIVERY_AGENT", seqB2!=null?seqB2.getTagValue("53A"):null);


        }   
        if(!data.isEmpty()){


        if(msg!=null && msg.getBlock2().isInput()){
            System.out.println("input   map");
            System.out.println(data);

             long seq=0;



        }   
        else if(msg!=null && msg.getBlock2().isOutput()){
        System.out.println("output   map");
            System.out.println(data);





        }
        }
        }





    }
}

=====================Mt320====================================================

public class Swift320Parser {


    public  void Mt320Parser(SwiftMessage msg,String fileName){
        if(msg!=null){
            MT320 mt=new MT320(msg);

            Map<String,String> list=null;
            Map<String,Object>data=new HashMap<String,Object>();
            System.out.println("320        parsew");

            System.out.println();
            System.out.println();           
            if(mt!=null){
            SequenceA seqA= mt.getSequenceA();
                data.put("OPERAT"
                        + "ION_TYPE", seqA!=null?seqA.getTagValue("22A"):null);
                data.put("PARTYB", seqA!=null?seqA.getTagValue("87A"):null);
                data.put("PARTYA", seqA!=null?seqA.getTagValue("82A"):null);
                data.put("SENDER_REFERENCE", seqA!=null?seqA.getTagValue("20"):null);
                data.put("TYPE_OF_EVENT", seqA!=null?seqA.getTagValue("22B"):null);
                //data.put("RELATED_REFERENCE", seqA!=null?seqA.getTagValue("21"):null);
                data.put("COMMON_REFERENCE", seqA!=null?seqA.getTagValue("22C"):null);

                SequenceB seqB= mt.getSequenceB();
                System.out.println(seqA.getTagMap());
                System.out.println(seqB.getTagMap());

                data.put("PARTYA_ROLE", seqB!=null?seqB.getTagValue("17R"):null);
                data.put("VALUE_DATE", seqB!=null?DateForamtConversion.parseDateYYYYMMDD((seqB.getTagValue("30V"))):null);
                data.put("MATURITY_DATE", seqB!=null?DateForamtConversion.parseDateYYYYMMDD(seqB.getTagValue("30P")):null);


                String str=seqB!=null?seqB.getTagValue("32B"):null;
                data.put("AMOUNT_BOUGTH", str!=null?str.substring(3).replace(",", "."):0.0);
                data.put("CURRENCY_BOUGHT", str!=null?str.substring(0,3):null);

                data.put("NEXT_INTEREST_DUE_DATE", seqB!=null?DateForamtConversion.parseDateYYYYMMDD(seqB.getTagValue("30X")):null);
                data.put("INTEREST_RATE", seqB!=null?seqB.getTagValue("37G").replace(",","."):null);
                data.put("DAY_COUNT_FRACTION", seqB!=null?seqB.getTagValue("14D"):null);

                String str3=seqB!=null?seqB.getTagValue("34E"):null;
                data.put("SIGN", str3!=null?str3.substring(0,1):null);
                data.put("INTEREST_CURRENCY", str3!=null?getData(str3,"[a-zA-Z]*"):null);
                data.put("INTEREST_AMOUNT", str3!=null?getData(str3, "[0-9,]*$").replace(",", "."):0.0);

            //


                SequenceC seqC= mt.getSequenceC();

                data.put("RECEIVING_AGENT1", seqC!=null?seqC.getTagValue("57A"):null);
                data.put("DELIVERY_AGENT", seqC!=null?seqC.getTagValue("53A"):null);
                SequenceD seqD= mt.getSequenceD();


                data.put("RECEIVING_AGENT2",seqD!=null?seqD.getTagValue("57A"):null);




                }
            if(!data.isEmpty()){

            if(msg!=null && msg.getBlock2().isInput()){
                System.out.println("input   map");
                System.out.println(data);

            }   
            else if(msg!=null && msg.getBlock2().isOutput()){
                System.out.println("output   map");
                System.out.println(data);

            }

        }

        }
        }

    public static String getData(String data, String token) {
        String retStr;
        StringBuilder result = new StringBuilder();
        if (data != null) {
            Pattern pattern = Pattern.compile(token);
            Matcher matcher = pattern.matcher(data);
            String sep = "";
            while (matcher.find()) {
                result.append(String.valueOf(String.valueOf("")) + matcher.group().toString());

            }
        }
        return (retStr = result.toString()).isEmpty() ? null : retStr;
    }

}

==================MT600==================================

public class MT600Parser {


    public void Mt600Parser(SwiftMessage msg,String fileName){
        Map<String,Object>data=new HashMap<String,Object>();
        if(msg!=null){
        MT600 mt=new MT600(msg);
        if(mt!=null){
            SequenceA seqA= mt.getSequenceA();
            data.put("PARTYA", seqA!=null?seqA.getTagValue("82A"):null);
            data.put("PARTYB", seqA!=null?seqA.getTagValue("87A"):null);
            String price=seqA!=null?seqA.getTagValue("33G"):null;
            String pricemount=  price.replace("," ,".");
            data.put("PRICE_PER_UNIT",pricemount );
            data.put("IDENTIFICATION", seqA!=null?seqA.getTagValue("26C"):null);

            SequenceB seqB= mt.getSequenceB();
            data.put("SENDER", seqB!=null?seqB.getTagValue("53A"):null);
            data.put("ACCOUNT", seqB!=null?seqB.getTagValue("57A"):null);
            data.put("RECEIVER", seqB!=null?seqB.getTagValue("87A"):null);          
            String str=seqB!=null?seqB.getTagValue("34P"):null;
            if(str!=null){
                data.put("CONSIDERATION", seqA!=null?seqB.getTagValue("34P"):null);
                String date=str.substring(0, 6);
                String cur=str.substring(6, 9);
                String stringamount=str.substring(9, str.length());//str.substring(str.length()-9);
                String convertedAmount= stringamount.replace("," ,".");
                double amount=Double.parseDouble(convertedAmount);
                data.put("TRA_DATE",date);  
                data.put("CURRENCY",cur);
                data.put("TRA_AMOUNT",amount);

            }else{
            data.put("CONSIDERATION", null);
            data.put("TRA_DATE",null);  
            data.put("CURRENCY",null);
            data.put("TRA_AMOUNT",null);
            }
            SequenceC seqC= mt.getSequenceC();
            data.put("QUANTITY", seqC!=null?seqC.getTagValue("32F"):null);
            }
        if(!data.isEmpty()){


        }
        if(msg!=null && msg.getBlock2().isInput()){
            System.out.println(data);

        }   
        else if(msg!=null && msg.getBlock2().isOutput()){

            System.out.println(data);

        }
        }
    }
}