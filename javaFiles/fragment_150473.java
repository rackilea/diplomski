public static void main(String[] args) {
        //Easy to calculate
        int[] coords = {4,5,2};
        System.out.println("out1:"+indexFromNDto1D(coords,7,3)); //233
        System.out.println("out2:"+Arrays.toString(indexFrom1DToND(233,7,3))); //{4,5,2}

        System.out.println("");
        //Just like the example
        int oldDimensionSize = 5;
        int newDimensionSize = 10;

        int oldNumberOfDimensions = 2;
        int newNumberOfDimensions = 5;

        int[] _2Dcoords = {2,4};
        int[] _5Dcoords = null;

        int idx = indexFromNDto1D(_2Dcoords,oldDimensionSize,oldNumberOfDimensions); //One dimension index
        System.out.println(idx);
        idx = transferFunction(idx); 
        System.out.println(idx);
        _5Dcoords = indexFrom1DToND(idx,newDimensionSize,newNumberOfDimensions); 
        System.out.println(Arrays.toString(_5Dcoords));

        System.out.println("Reversing");

        idx = indexFromNDto1D(_5Dcoords,newDimensionSize,newNumberOfDimensions);
        System.out.println(idx);
        idx = reverseTransfertFunction(idx);
        System.out.println(idx);
        _2Dcoords = indexFrom1DToND(idx,oldDimensionSize,oldNumberOfDimensions);
        System.out.println(Arrays.toString(_2Dcoords));
    }

    public static int indexFromNDto1D(int[] coords, int dimLength, int numberOfDimensions){
        //Could've use numberOfDimensions = coords.length but for symetry with the other method...
        int result = 0;

        for(int currDim = 0; currDim < numberOfDimensions; currDim++){
            int shift = (int) (Math.pow(dimLength, numberOfDimensions - currDim - 1) * coords[currDim]);
            result+= shift;
        }

        return result;
    }

    public static int[] indexFrom1DToND(int idx, int dimLength, int numberOfDimensions){
        int[] result = new int[numberOfDimensions];

        for(int currDim = 0; currDim < numberOfDimensions ; currDim++){
            int currentDimSize = (int) Math.pow(dimLength,numberOfDimensions-1-currDim);
            result[currDim] = idx / currentDimSize;
            idx = idx %  currentDimSize; 
        }

        return result;
    }

    static final int transfer = 4000;

    public static int transferFunction(int idx){
        return idx * transfer;
    }

    public static int reverseTransfertFunction(int idx){
        return idx / transfer;
}