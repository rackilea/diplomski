int i = 0, 
inputCount = 0;
char letter = 'a';
String[] coefficient = new String[MAX_LENGTH];  
do{ 
    System.out.print("What is " + letter +"? ");
    coefficient[i] = keyboard.nextLine();
    i++;
    letter++;
    inputCount++;           
}while(!coefficient[i-1].equals("X"));