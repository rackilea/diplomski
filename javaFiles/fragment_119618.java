package com.company;

import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        String line;
        String cline = "";
        Document doc;
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));

            while ((line = br.readLine()) != null) {
                cline = line;
            }

            doc = Jsoup.parse(cline);
            Elements elements = doc.select("body").first().children();
            for (Element el : elements)
                System.out.println("content: " + el.text());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}