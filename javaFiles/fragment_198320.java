public static int[] calcRectangleArea(List<Double> width, double[] length) 
    { 
        int[] area=new int[length.length];
        for(int index = 0; index < length.length; index++) 
        { 
            area[index] = (int) (length[index]*width.get(index));
        }
        return area; 
    }