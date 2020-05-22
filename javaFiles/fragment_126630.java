import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.longevitysoft.android.xml.plist.PListXMLHandler;
import com.longevitysoft.android.xml.plist.PListXMLParser;
import com.longevitysoft.android.xml.plist.domain.Array;
import com.longevitysoft.android.xml.plist.domain.Dict;
import com.longevitysoft.android.xml.plist.domain.PList;
import com.longevitysoft.android.xml.plist.domain.PListObject;

public class PlistReader {

    public static void main(String[] args) throws Exception {
        PListXMLParser parser = new PListXMLParser();
        PListXMLHandler handler = new PListXMLHandler();
        parser.setHandler(handler);
        parser.parse(readFile("plist.xml"));
        PList pList = ((PListXMLHandler) parser.getHandler()).getPlist();
        Dict root = (Dict) pList.getRootElement();
        // This Array class is java.util.ArrayList<PListObject> underneath the
        // covers
        Array theList = root.getConfigurationArray("Objects");
        for (PListObject obj : theList) {
            switch (obj.getType()) {
                case DICT:
                    Dict dictionaryObj = (Dict) obj;
                    // dictionaryObj.getConfigurationObject(key);
                    // dictionaryObj.getConfigurationInteger(key);
                    // dictionaryObj.getConfiguration(key);
                    // dictionaryObj.getConfigurationArray(key)
                    break;

                case STRING:
                    com.longevitysoft.android.xml.plist.domain.String stringObj = (com.longevitysoft.android.xml.plist.domain.String) obj;
                    break;

                default:
                    break;
            }
        }
    }

    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

}