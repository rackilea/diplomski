BufferedReader br = new BufferedReader(new FileReader(fileName));
ArrayList<DueDate> tasks = new ArrayList<DueDate>();
String line = "";
while((line = br.readLine()) != null) {
    String[] values = line.split("\t");
    if(values.length == 2) {
        String addedTask = values[0];
        String enteredDueDate = values[1];
        DueDate d = new DueDate(addedTask, enteredDueDate);
        tasks.add(d);
    }
}
Collections.sort(tasks);
br.close();
//Changed it to not append but overwrite the old file so it only contains the sorted list
BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false));
for (DueDate date : tasks) {
    String lineText = date.toString();
    bw.write(lineText);
    bw.newLine();
}
bw.flush();
bw.close();