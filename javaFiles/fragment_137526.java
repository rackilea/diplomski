Reader fileReader = new BufferedReader(new FileReader("letters01.dat"));
/* or:
Reader fileReader = new BufferedReader(
    new InputStreamReader(
        new FileInputStream("letters01.dat"),
        "the file's charset here"
    )
); 
*/