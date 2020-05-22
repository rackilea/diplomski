String[] array = new String[6];
for (int i = 0; i < numberOfLinesToRead; i++) {
    recarray[i] = new MyRecord(); // Make sure to initialize the object before accessing it
    array = scan.nextLine().replaceAll(" ", "").split(","); // The array object now contains each individual value of one line
    recarray[i].firstname = array[0];
    recarray[i].lastname = array[1];
    recarray[i].email = array[2];
    recarray[i].idnumber = Double.parseDouble(array[3]);
    recarray[i].color = array[4];
    recarray[i].balance = Double.parseDouble(array[5]);
}