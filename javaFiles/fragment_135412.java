public static void calculateDogValues(){
    List<Double> dogWeightList = new ArrayList<>();
    double max = 0, min = 0, average = 0;
       for(Pet pet: mainList){
          if (pet instanceof Dog){    //add all dog weights to list
              dogWeightList.add(pet.getWeight());
          }
       }

       Collections.sort(dogWeightList);   //sort the list
       min = dogWeightList.get(0);   //get smallest value
       max = dogWeightList.get(dogWeightList.size()-1);   //get highest value

       for (double weight : dogWeightList) {   //make sum of all weights
          average += weight;
       }
       average = average/dogWeightList.size();   //sum/number of weights

       System.out.println("Minimum weight is " + min);
       System.out.println("Maximum weight is " + max);
       System.out.println("Average weight is " + average);

    }