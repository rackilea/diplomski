String line = "";
int i = 0;
while (line != null) {
    line = br.readLine();    
    if (line != null) {    // CHeck if line is null or not
        checklistList.add(fillList("list", line.substring(13, 29)));
    }
    i++;
}