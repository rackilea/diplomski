int b; // byte number as int, can be converter to char

for(i = 0; (char)(b = (int)System.in.read()) != 'S'; ++i)
{
    System.out.println("DEBUG: byte = " + b.ToString());
    System.out.println("Pass # " + i);
}