private String FileName;

public void setName(){

Scanner input = new Scanner(System.in);
String FileName;

do{#Until the user enters a proper input it should continue to ask for input
    System.out.println("Please enter the name of the input file!");
    if(input.hasNextLine()){
        FileName = input.next();
        this.FileName = FileName

    }else{
        System.out.println("Please enter a valid name");
    }

public String getName(){
    return FileName;#The IDE says it can't resolve symbol FileName
}