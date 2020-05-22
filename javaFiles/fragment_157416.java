public static void main (String ...a)
{
Products o= new Products("Chocolate"); 
o.addToList();
Products o1= new Products("Icecream");
o1.addToList();
new Products().showList(); //This line is the culprit