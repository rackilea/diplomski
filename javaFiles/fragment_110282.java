public void recursionMethod(ArrayList<Point2D.Double> c, int size, int count){
      if(count<size-1){
        double xA = c.get(count).getX();
        double yA = c.get(count).getY();
        double xB = c.get(count+1).getX();
        double yB = c.get(count+1).getY();

        exAdding = c.get(size-1).getX()*c.get(size-size).getY();
        adding = adding + xA*yB; 

        exMinus = c.get(size-1).getY()*c.get(size-size).getX();
        minus = minus + yA*xB;
        recursionMethod(c, size, count+1);
       }
    }