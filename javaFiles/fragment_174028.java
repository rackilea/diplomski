//First create an array list of integer and use your same for loop to add all values in that array from 0 to 100

List<Integer> list = new ArrayList<Integer>();

for(int i = 0; i < 100; i++)
{
list.add(i);    
}

//Now you should able to use whether foreach or iterator to execute method for each array (int) value one by one.

//Foreach example:

for (Integer i : list) {

my_method(i); //your method to execute

} 

//Iterator example:

for (Iterator i = list.iterator(); i.hasNext();) {

my_method(i); //your method to execute

}