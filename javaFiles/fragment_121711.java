public  ArrayList<Dicionario> retornaArray() {
    controlaBanco = new controlaBanco(this);//the classe with methods to manipule the data in a database
    cursor = controlaBanco.carregaDados(); //this will give me the cursor with some data from a database(sqlite)
    arr = new ArrayList<Dicionario>(); //an arraylist formated to hand my data and then put it in a personalized listview

    while (cursor.moveToNext() && cursor.getPosition() < 1000) {

       //here I take that data to formating this in my class
       arr.add(new Dicionario(
            cursor.getString(0), 
            cursor.getString(1), 
            cursor.getString(2), 
            cursor.getString(3)
        ));

    }
//now I receive the array and returning this to my personalized adapter
    return arr;
}