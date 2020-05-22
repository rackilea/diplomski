public class Manual {

    String serialNumber, title, author;

    public Manual(){
        serialNumber = "??????";
        title = "Untitled";
        author = "Unknown";
    }

public void printDetails(){
   System.out.println("S.no= " +serialNumber+" Title= "+ title+"author= "+author)

}

public static void main(String [] args){
        Manual man= new Manual();
        man.printDetails();
    }

}