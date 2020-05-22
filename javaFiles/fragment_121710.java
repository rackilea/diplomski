public  ArrayList<Dicionario> retornaArray() {
    controlaBanco = new controlaBanco(this);//the classe with methods to manipule the data in a database
    //List<String> str = new ArrayList<>(); //<<< not needed
    cursor = controlaBanco.carregaDados(); //this will give me the cursor with some data from a database(sqlite)
    arr = new ArrayList<Dicionario>(); //an arraylist formated to hand my data and then put it in a personalized listview

    int count = 0; //an number to control the data flow(it's 3000 linea of data and I guess my application might get slow by this

    while (!cursor.isAfterLast() && count <= 1000) {


//here I take that data to formating this in my class
        dicionario = new Dicionario(
            cursor.getString(0), 
            cursor.getString(1), 
            cursor.getString(2), 
            cursor.getString(3)
        );

//here I put my formated data into my formated array
        arr.add(dicionario);

        count++; //the count is upping...
    }
//now I receive the array and returning this to my personalized adapter
    return arr;
}