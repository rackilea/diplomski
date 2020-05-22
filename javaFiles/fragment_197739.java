final String filename = "abc.text";
File file = new File(filename);
// moved out of onClickListener
final List arrlist = new ArrayList();
try {
        // load the previous contents if it exists

        FileInputStream fis = openFileInput(filename);
        ObjectInputStream restore = new ObjectInputStream(fis);
        ArrayList newArrList = (ArrayList) restore.readObject();
        arrlist.addAll(newArrList);
        restore.close();
        fis.close();
} catch (FileNotFoundException e) {
    // ignore, maybe log
} catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch (OptionalDataException e) {
    e.printStackTrace();
} catch (StreamCorruptedException e) {
    e.printStackTrace();
} catch (IOException e) 
    e.printStackTrace()
}

b2.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v
            ) {

                String listtext = a1.getText().toString();     //a1 is edittext

                if (listtext.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter product", Toast.LENGTH_SHORT).show();

                } else {

                    arrlist.add(listtext);
                    a1.setText("");
                    try {