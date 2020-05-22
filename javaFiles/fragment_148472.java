private Long lastTimeUserClicked = null;

public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Long clickTime = System.currentTimeInMillis();
    if(lastTimeUserclicked==null || clickTime - lasTimeUserClicked > 1000) { //1000 millisecs = 1 sec
      //Do your stuff ...
      lastTimeUserClicked = clickTime;   
    }
}