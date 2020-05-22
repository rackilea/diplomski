import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader1 {

    public XmlReader1() {

        try {

            String str = ""; String strAdd;
            String bR  = "<(?!/)(.*?)>";
            String pR  = ">(?!<)(.*?)<(/.*?)>";
            File file = new File("E:\\test\\b.xml");
            BufferedReader br = null;
            int s1 = 0; int s2 = 0; int s3 = 0; int s31 = 0; int mb = 0; int mp = 0;

            //dosyadan verinin çekilip str stringine atanması.
            br = new BufferedReader(new FileReader(file));
            while ((strAdd = br.readLine()) != null) {
                str += strAdd; 
            }

            Pattern pattern1 = Pattern.compile(bR);
            Matcher matcher1 = pattern1.matcher(str);

            Pattern pattern2 = Pattern.compile(pR);
            Matcher matcher2 = pattern2.matcher(str);

            Pattern pattern3 = Pattern.compile(bR);
            Matcher matcher3 = pattern3.matcher(str);

            Pattern pattern4 = Pattern.compile(pR);
            Matcher matcher4 = pattern4.matcher(str);

            //dosyadaki elementlerin(<...>) sayılması.
            while (matcher1.find()) {
                mb++;
            }

            //dosyadaki çocuk elementlerin(<...>child</..>) sayılması.
            while (matcher2.find()) {
               mp++;
            }

            //elementler dizisi.
            String mB[] = new String[mb];
            //çocuk elemanlar dizisi.
            String mP[] = new String[mp];

            //dosyadaki elementlerin mP[] dizisine atanması.
            while (matcher4.find()) {
               mP[s2] = matcher4.group(1);
               s2++;
            }

            //dosyadaki çocuk elemanların mB[] dizisine atanması.
            while (matcher3.find()) {
                mB[s1] = matcher3.group(1);
                s1++;
            }

            //dom parser işlemleri.
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new FileInputStream(file));

            NodeList nL = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
            Node nD = nL.item(0);
            Element eL = (Element) nD;

            int big[] = new int[mp];            
            //element gruplarının kaç kişi olduğunun bulunması.
            for (int i = 0; i < mp; i++) {
                for (int j = 1; j < mb; j++) {

                    String a = eL.getElementsByTagName(mB[j]).item(0).getTextContent();
                    String b = mP[i];

                        if (a.equals(b)) {
                            s3++;
                        }       
                }   
                    big[i] = s3;
                    s3 = 0;
            }               

            //2 boyutlu ana dizinin dinamik sütun sayıları belirtilmeden tanımlanması.
            String add[][] = new String[mp][];      

            //ana diziye element ve elemanların birbirine bağlanarak atanması.
            for (int i = 0; i < mp; i++) {

                //ana dizinin sütun sayısı, her element-eleman grubunun sayısına göre oluşturulması.
                add[i] = new String[big[i]+1];

                //ana diziye elementleri ekleme işlemi.
                for (int j = 1; j < mb; j++) {

                    //verilen mB[] dizisindeki elementin ismine göre, o elementin çocuğunun bulunması.
                    String a = eL.getElementsByTagName(mB[j]).item(0).getTextContent();
                    //çocuk elemanlar dizisi.
                    String b = mP[i];

                        //String a'daki ortak çocuğa sahip elementlerin aynı dalda gruplandırılması.
                        if (a.equals(b)) {
                            add[i][s3] = mB[j];
                            s3++;
                        }       
                }   
                    //gruplanan elementlere çocukların eklenmesi.
                    add[i][s3] = mP[i];
                    s3 = 0;
            }

            //ana dizinin yazdırılması.
            for (int i = 0; i < add.length; i++) {
                for (int j = 0; j < add[i].length; j++) {
                    System.out.println(add[i][j]);
                }
            }



        } catch (Exception e) {
            System.err.println("Hata!");
        }

    }

    public static void main(String[] args){

        XmlReader1 x = new XmlReader1();

    }
}