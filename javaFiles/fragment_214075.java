public ArrayList<String> permute(String array[][], 
 int index, ArrayList<String> output, ArrayList<String> comb){
        if(index == array.length){
            comb.add(output.toString());            
        }
        else{
            for(int i=0 ; i<array[index].length ; i++){
                output.add(array[index][i]);
                permute(array,index+1,output, comb);
                output.remove(output.size() - 1); 
            }
        }

        return comb;
    }