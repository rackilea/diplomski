package test;

import java.util.List;

import com.ui4j.api.browser.BrowserEngine;
import com.ui4j.api.browser.BrowserFactory;
import com.ui4j.api.browser.Page;
import com.ui4j.api.dom.Document;
import com.ui4j.api.dom.Element;
import com.ui4j.api.dom.Select;

public class WebScraping {

    public static void main(String[] args) throws InterruptedException {
        BrowserEngine webkit = BrowserFactory.getWebKit();

        // load the page
        Page page = webkit.navigate("https://gaiacrmkea.c-gaia.gr/city_thessaloniki/index.php");
        page.show();

        // get the DOM
        Document document = page.getDocument();

        // find the year combobox
        Select year = document
                        .query("#fyear")
                        .getSelect();

        // select year 2011
        year.setSelectedIndex(0);
        // trigger the change event
        year.change();

        // Small delay before the page load
        Thread.sleep(2000);

        // find the data table
        Element table = document
                            .query("#example")
                            .query("tbody");

        // iterate all rows
        List<Element> rows = table.queryAll("tr");
        for (int i = 0; i < rows.size(); i++) {
            Element row = rows.get(i);

            // iterate all columns
            List<Element> cells = row.queryAll("td");

            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < cells.size(); j++) {
                Element cell = cells.get(j);
                String text = cell.getText();
                builder.append(text).append(" ");
            }

            System.out.println(builder.toString());
        }
    }
}