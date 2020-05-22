public static void permute(String array[][], int index, ArrayList<String> output){

    if(index == array.length){
        System.out.println(output.toString());
    }
    else{
        for(int i=0 ; i<array[index].length ; i++){
            output.add(array[index][i]);
            permute(array,index+1,output);
            output.remove(output.size() - 1); 
        }
    }
}