private boolean CircleExists(Point origin, ArrayList<Circle> circles){

        boolean output = false;
        for(int i = 0; i < circles.size(); i++){

            Circle cir = circles.get(i);
            if(cir.contains(origin.x, origin.y)){
                output = true;
            }

        }

        return output;
    }