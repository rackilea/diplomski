class a{

    public int[] convert_array(String input){
            String[] intStringArray = input.split(",")
            int[] returnArray = new int[intStringArray.size()] //make it the same size as the split string 

        for(int i = 0; i < intStringArray.size(); i++){
                returnArray[i] = Integer.valueOf(intStringArray[i]);
        }
    return returnArray
    }

public static void main(String args[]){
a obj=new a();
int[] firstArray = obj.convert_array(input1);//First Input String
int[] secondArray = obj.convert_array(input2);//First Second String
    }