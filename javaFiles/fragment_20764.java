String a = "background-image: url(www.google.com); background-repeat: no-repeat;-webkit-background-size: 1001px 1903px;height: 1903px; width: 1001px; text-align: center; margin: 0 auto;";
HashMap kv = new HashMap();
for(String b : a.split(";")){
    String[] temp = b.split(":");
    kv.put(temp[0], temp[1]);
}