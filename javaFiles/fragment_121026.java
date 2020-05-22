// pre-defined names and strengths...
String name1 = "rubelwifii";
int strength1 = -50;
String name2 = "aliwifi";
int strength2 = -92;
String name3 = "ABDULHAKEEM";
int strength3 = -55;
String name4 = "shamwifi";
int strength4 = -70;
String name5 = "Fuselage";
int strength5 = -84;

// a hashmap to store your results
HashMap<String, ScanResult> hashMap = new HashMap<String, ScanResult>();

tv = (TextView) findViewById (R.id.textView1);

List <ScanResult> results = wm.getScanResults ();

String otherwifi="The existing network is:\n\n";
System.out.println(result.SSID.toString());     
System.out.println(result.level);
for (ScanResult result: results) { 
    // store the result in a hashmap so you can get at it later
    hashMap.put(result.SSID.toString(), result);

    otherwifi+=result.SSID+":"+result.level+"\n";
    tv.setText (otherwifi);
}

// do something with the first and second result
ScanResult result1 = hashMap.get(name1);
ScanResult result2 = hashMap.get(name2);

// compare strength of #1 to the predefined value... (I'm assuming int is the data type)
if ( result1.level == strength1 ) {
    // do something
}

// do same for #2
if ( result2.level == strength2 ) {
    // do something...
}