import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Kereso {

    public static void main(String[] args) throws IOException {
        String html = "http://www.szerencsejatek.hu/xls/otos.html";
        List<Huzas> listOfHuzas = new ArrayList<Huzas>();

        Document doc = Jsoup.connect(html).get();
        Elements rows = doc.select("tr");
        rows.remove(0); //Remove head row
        for (Element row : rows) {
            Elements children = row.children();
            listOfHuzas.add(new Huzas(children.get(0).text(), // ev
                            children.get(1).text(), // het
                            children.get(2).text(), // huzasdatum
                            children.get(3).text(), // otosDb
                            children.get(4).text(), // otos
                            children.get(5).text(), // negyesDb
                            children.get(6).text(), // negyes
                            children.get(7).text(), // harmasDb
                            children.get(8).text(), // harmas
                            children.get(9).text(), // kettesDb
                            children.get(10).text(), // kettes
                            Integer.parseInt(children.get(11).text()), // szam1
                            Integer.parseInt(children.get(12).text()), // szam2
                            Integer.parseInt(children.get(13).text()), // szam3
                            Integer.parseInt(children.get(14).text()), // szam4
                            Integer.parseInt(children.get(15).text())) // szam5
                        );
        }
        System.out.println(listOfHuzas);
    }
}