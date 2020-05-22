double max = 0, min = 0, average = 0, amountOfDogs = 0;
       for(Pet dog: mainList){
          if (dog instanceof Dog){   
              min = Math.min(min, dog.getWeight()); 
              max = Math.max(max, dog.getWeight());
              average += dog.getWeight();
              amountOfDogs++;
          }
       }
       average = average/amountOfDogs;

       System.out.println("Minimum weight is " + min);
       System.out.println("Maximum weight is " + max);
       System.out.println("Average weight is " + average);

    }