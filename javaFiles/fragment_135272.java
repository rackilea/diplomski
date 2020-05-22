String time = jTextField1.getText();
StringTokenizer st = new StringTokenizer(time, ":");
List<String> timeList = new ArrayList<String>();
while(st.hasMoreTokens()){
        timeList.add(st.nextToken());
    }