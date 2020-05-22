StringBuilder str = new StringBuilder();

switch (oper){
    case ('A'):
    case ('a'):
        do{
            str.append(num%2);
            num=(num/2);
        }while(num>=1);
        break; 
}

System.out.print(str.reverse().toString());