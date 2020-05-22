ArrayList<String> arrayList = new ArrayList<String>();
arrayList.add("Buffon");
arrayList.add("");
arrayList.add("Messi");
arrayList.add("");
int count= 0;
for(String player:arrayList){
    if(!player.equals("")){
        count++;
    }
}
Log.d("playercount", "currentPlayers: "+count);