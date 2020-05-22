final Set<Map.Entry<String, Map<String, Map<String, Map<String, String>>>>> section = array.entrySet();
final Iterator<Map.Entry<String, Map<String, Map<String, Map<String, String>>>>> sectionI = section.iterator();
while (sectionI.hasNext()) {
    final Entry<String, Map<String, Map<String, Map<String, String>>>> sectionInfo = sectionI.next();
    final Map<String, Map<String, Map<String, String>>> subMap = sectionInfo.getValue();
    final Set<Map.Entry<String, Map<String, Map<String, String>>>> subSet = subMap.entrySet();
    final Iterator<Map.Entry<String, Map<String, Map<String, String>>>> subI = subSet.iterator();
    while (subI.hasNext()) {
        final Map.Entry<String, Map<String, Map<String, String>>> subInfo = subI.next();
        final Map<String, Map<String, String>> subsubMap = subInfo.getValue();
        final Set<Map.Entry<String, Map<String, String>>> subsubSet = subsubMap.entrySet();
        final Iterator<Map.Entry<String, Map<String, String>>> subsubI = subsubSet.iterator();
        while (subsubI.hasNext()) {
            System.out.println("test");
            final Map.Entry<String, Map<String, String>> subsubInfo = subsubI.next();
            final Map<String, String> subcontentsMap = subsubInfo.getValue();
            final Set<Map.Entry<String, String>> subcontentsSet = subcontentsMap.entrySet();
            final Iterator<Map.Entry<String, String>> entries = subcontentsSet.iterator();
            while (entries.hasNext()) {
                final Map.Entry<String, String> entry = entries.next();
            }
        }
    }
}