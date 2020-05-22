double bonePrice = 0.00;

for (int i = 0; i < stalls.size(); i++){

    ..

    bonePrice += boneCost* stalls.get(i).numberOfFeedings;
}

System.out.println("$5.00 spent feeding 1 cow(s) 5 total feedings"
                    + "\n$25.00 spent feeding 1 cat(s) 5 total feedings"
                    + bonePrice +"\nspent feeding 1 dog(s) 5 total feedings" 
                    + "\n\tTotal Cost: " + /*total cost**/);