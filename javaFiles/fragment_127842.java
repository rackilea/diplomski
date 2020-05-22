public static void main(String[] args) {
function();
}
public static void function(){
Scanner sc = new Scanner (System.in);

String name;
System.out.println("Input Name");
name = sc.nextLine();

StringBuilder rev = new StringBuilder(name);


System.out.println("NAME: "+name+"\n");

System.out.println("REVERSE:" +rev.reverse()+"\n");

System.out.println("Would you like to do it again?(Y/N)\n");

char repeat;

repeat = sc.next().charAt(0);


if(repeat == 'n'){
    System.out.println("Program  Stopped");
}
    if(repeat == 'y'){

function();

    }

}