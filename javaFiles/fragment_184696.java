import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ExampleTest {

    @Test
    public void test() {

        // Create maps to combine
        Map<String, String> mapA = new LinkedHashMap<>();
        Map<String, String> mapB = new LinkedHashMap<>();

        // Create final map
        Map<String, List<String>> mapC = new LinkedHashMap<>();

        // Add data to input mapA
        mapA.put("A", "value1");
        mapA.put("B", "value2");

        // Add data to input mapB
        mapB.put("C", "Happy");
        mapB.put("B", "Sad");

        // Fill results from mapA
        mapC = populateMapCWithMapContent(mapC, mapA);
        mapC = populateMapCWithMapContent(mapC, mapB);

        // Check Results
        assertEquals(2, mapA.size());
        assertEquals(2, mapB.size());
        assertEquals(3, mapC.size());

        // show results
        for (String key : mapC.keySet()) {
            System.out.println("Key=" + key);
            List<String> values = mapC.get(key);
            for (String value : values) {
                System.out.println("    Value = " + value);
            }
        }

    }

    /**
     * Populate mapC with provided map Contents
     * 
     * @param mapC
     *            - resulting map
     * @param map
     *            - input data
     * @return mapC
     * 
     *         Note: this would work with a void, but I always feel that if mapC is
     *         changed, then mapC should be returned (To help readability). 
     */
    private Map<String, List<String>> populateMapCWithMapContent(Map<String, List<String>> mapC,
            Map<String, String> inputMap) {
        List<String> mapCValues;
        for (String key : inputMap.keySet()) {
        if (mapC.containsKey(key)) {
                mapCValues = mapC.get(key);
            } else {
                mapCValues = new ArrayList<String>();
            }
            mapCValues.add(inputMap.get(key));
            mapC.put(key, mapCValues);
        }
        return mapC;
    }
}