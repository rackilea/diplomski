import java.util.HashMap;
import java.util.Map;


    Map<String, Download> downloaders = new HashMap<String, Download>();

    downloaders.put("Youtube", new DownloadYoutube());
    downloaders.put("Vimeo", new DownloadVimeo());


    // Iterate over all downloaders, using the keySet method.
    for(String key: downloaders.keySet())
        Download d = downloaders.get(key)
    System.out.println();