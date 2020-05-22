char mark = grade.charAt(0);
char modifier = 0;

if(grade.length() > 1)
{
    modifier = grade.charAt(1);
}

switch(mark)
{
    case 'A':
        switch(modifier)
        {
            case '+': System.out.println("A+"); break;
            case '-': System.out.println("A-"); break;
            default: System.out.println("A"); break;
        }
        break;
    case 'B':
        break;
    case 'C':
        break;
}