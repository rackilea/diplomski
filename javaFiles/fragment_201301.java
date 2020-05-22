String str = "ID=1923\nZ=19\nX=123\nY=102\r\nID=133\nZ=11\nX=14\nY=12r\nID=1313\nZ=121\nX=134\nY=19";
    StringTokenizer st = new StringTokenizer(str, "\n");

    List<String> idList = new ArrayList<String>();
    List<String> zList = new ArrayList<String>();
    List<String> xList = new ArrayList<String>();
    List<String> yList = new ArrayList<String>();

    while(st.hasMoreElements()) {
        String tempKey = (String)st.nextElement();
        String tempValue = tempKey.split("=")[1];
        if(tempKey.startsWith("ID")) {
            idList.add(tempValue);
        } else if(tempKey.startsWith("Z")) {
            zList.add(tempValue);
        } else if(tempKey.startsWith("Y")) {
            yList.add(tempValue);
        } else if(tempKey.startsWith("X")) {
            xList.add(tempValue);
        }
    }
    for (List<String> list : new ArrayList<List>(Arrays.asList(idList, zList, xList, yList))) {
        for (String id : list) {
            System.out.println(id);
        }
    }