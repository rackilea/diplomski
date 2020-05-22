Set<Map.Entry<String, Object>> section = array.entrySet();
Iterator<Map.Entry<String, Object>> sectionI = section.iterator();
while (sectionI.hasNext()) {
    Map.Entry<String, Object> sectionInfo = sectionI.next();
    Map<String, Object> subMap = (Map<String, Object>) sectionInfo.getValue(); // is this actually a Map<String, Object>?
    Set<Map.Entry<String, Object>> subSet = subMap.entrySet();
    Iterator<Map.Entry<String, Object>> subI = subSet.iterator();
    while (subI.hasNext()) {
        Map.Entry<String, Object> subInfo = subI.next();
        Map<String, Object> subsubMap = (Map<String, Object>) subInfo.getValue(); // is this actually a Map<String, Object>?
        Set<Map.Entry<String, Object>> subsubSet = subsubMap.entrySet();
        Iterator<Map.Entry<String, Object>> subsubI = subsubSet.iterator();
        while (subsubI.hasNext()) {
            System.out.println("test");
            Map.Entry<String, Object> subsubInfo = subsubI.next();
            Map<String, Object> subcontentsMap = (Map<String, Object>) subsubInfo.getValue(); // somehow a String got in here?
/*
The above line seems to be causing the issues.
If you comment out the rest of this loop (below this comment)
the error will still appear. If you comment out the rest of this loop
(including the line above this comment) it disappears.
Power of deduction my dear Watson.
*/
            Set<Map.Entry<String, Object>> subcontentsSet = subcontentsMap.entrySet();
            Iterator<Map.Entry<String, Object>> keys = subcontentsSet.iterator();
            while (keys.hasNext()) {
                Map.Entry<String, Object> keyMap = keys.next();
            }
            Iterator<Map.Entry<String, Object>> values = subcontentsSet.iterator();
            while (values.hasNext()) {
                Map.Entry<String, Object> valueMap = values.next();
            }
        }
    }
}