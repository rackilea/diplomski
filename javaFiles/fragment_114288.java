public class Main {
    public static void main(String args[]){

        ArrayList<Point> pointlist =  new ArrayList<>(); //Now that we aren't using a nested class, Just <Point>            

        //Creating map
        int row = 40;
        int col = 40;
        int [][] bigarray = new int [row] [col];

        //iterating through map
        for (int i = 0; i < row; i++){ //No semicolon after i++
            for (int j=0; j< col; j++){
                Point pt = new Point(); //Calling a constructor is a method, hence ()
                pt.x = j; //You probably mean j and k here, not row and col (which don't change)
                pt.y = k;
                pt.z = 0;//RNG HERE// //Not sure what you mean here, but you can set pt.z to whatever you want

                //You created pointlist, but never add to it. Did you mean to?
                pointlist.add(pt);
            }
        }
    }
}