public Car mostPrizes (Car car)
    {
        if(car== null){
            return null;
        }
        Car leftMax= mostPrizes(car.left);
        Car rightMax= mostPrizes(car.right);

        if(leftMax!=null){
            if(car.getPrizes().size()>leftMax.getPrizes().size()){
                return node;
            }
            else{
                return leftMax;
            }
        }
        if(rightMax!=null){
            if(car.getPrizes().size()>rightMax.getPrizes().size()){
                return node;
            }
            else{
               return rightMax;
            }
        }
        return car;
    }