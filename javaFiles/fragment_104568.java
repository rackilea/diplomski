private int entryCounter = 1;

public void onClick(View v) {
    try {
        BufferedWriter out = new BufferedWriter(new FileWriter("/sdcard/input_data.txt", true));
        out.write(counter + ", " + txtData.getText() + "," + dateFormat.format(new Date()));
        entryCounter++;
    ...