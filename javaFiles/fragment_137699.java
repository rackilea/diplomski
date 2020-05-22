private static void parseLine(String pLine, Map<Integer, String> pHeaderMap) {
    for (int i = 0; i < pLine.length(); i++) {
        String currChar = String.valueOf(pLine.charAt(i));
        if (!currChar.equals(" ")) {
            int valueColumnIndex = getNearestColumnIndex(i, pHeaderMap);
            System.out.println("Value " + currChar + " is on column " + pHeaderMap.get(valueColumnIndex));
        }
    }
}

private static int getNearestColumnIndex(int pIndex,
        Map<Integer, String> pHeaderMap) {
    int minDiff = 500;
    int nearestColumnIndex = -1;
    for(Map.Entry<Integer, String> mapEntry : pHeaderMap.entrySet()) {
        int diff = Math.abs(mapEntry.getKey() - pIndex);
        if (diff < minDiff) {
            minDiff = diff;
            nearestColumnIndex = mapEntry.getKey();
        }
    }

    return nearestColumnIndex;
}