String fruitToPrint = "";
if (num == 0)
   fruitToPrint = "Cherries";
else if (num == 1)
   fruitToPrint = "Oranges";
else if (num == 2)
   fruitToPrint = "Plums";
else if (num == 3)
   fruitToPrint = "Bells";
else if (num == 4)
   fruitToPrint = "Melons";
else if (num == 5)
   fruitToPrint = "Bars";
else
   System.out.println("Couldn't assign fruit from num=" + num);

System.out.println("The corresponding fruit was " + fruitToPrint);