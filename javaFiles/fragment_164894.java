package com.example.mimetype;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

public class MimeUtils {

    // After calling this method, you can retrieve a list of URLs for each mimetype.
    public static Map<String, List<String>> sortLinksByMimeType(List<String> links) {
        Map<String, List<String>> mapMimeTypesToLinks = new HashMap<String, List<String>>();

        for (String url : links) {
            try {
                String  mimetype = getMimeType(url);

                System.out.println(url + " has mimetype " + mimetype);

                // If this mimetype hasn't already been initialized, initialize it.
                if (! mapMimeTypesToLinks.containsKey(mimetype)) {
                    mapMimeTypesToLinks.put(mimetype, new ArrayList<String>());
                }

                List<String> lst = mapMimeTypesToLinks.get(mimetype);
                lst.add(url);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return mapMimeTypesToLinks;
    }

    public static String getMimeType(String url) throws MalformedURLException, IOException, MagicParseException, MagicMatchNotFoundException, MagicException {
        // first attempt at determining MIME type--returned null for all URLs that I tried
//      FileNameMap filenameMap = URLConnection.getFileNameMap();
//      return filenameMap.getContentTypeFor(url);

        // second attempt at determining MIME type--worked better, but still returned null for many URLs
//      URLConnection c = new URL(url).openConnection();
//      InputStream in = c.getInputStream();
//      String mimetype = URLConnection.guessContentTypeFromStream(in);
//      in.close();
//      return mimetype;

        URLConnection c = new URL(url).openConnection();
        BufferedInputStream in = new BufferedInputStream(c.getInputStream());
        byte[] content = new byte[100];
        in.read(content);
        in.close();

        return Magic.getMagicMatch(content, false).getMimeType();
    }

    public static void main(String[] args) {
        List<String> links = new ArrayList<String>();
        links.add("http://stackoverflow.com/questions/10082568/how-to-differentiate-xml-from-html-links-in-java");
        links.add("http://stackoverflow.com");
        links.add("http://stackoverflow.com/feeds");
        links.add("http://amazon.com");
        links.add("http://google.com");

        sortLinksByMimeType(links);
    }
}