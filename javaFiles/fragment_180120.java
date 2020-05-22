public class MyClass {
        public static void main(String args[]) {
            int i,j,tempValue;
            int array[]= {4,1,2,5,3,6,8,7,10,9};
            boolean ok=true;

            for(i = 0 ; i < array.length/2  ; i++){
                    ok = false;
                    for(j = i ; j < array.length/2  ; j++){
                        if(array[j]>array[j+1]){
                            tempValue = array[j];
                            array[j] = array[j+1];
                            array[j+1] = tempValue;
                            ok = true;
                        }
                    }
                    if(ok == false)
                        break;
                }
                for(i = array.length/2 ; i < array.length  ; i++){
                    ok = false;
                    for(j = array.length/2 ; j < array.length - 1; j++){
                        if(array[j]<array[j+1]){
                            tempValue = array[j];
                            array[j] = array[j+1];
                            array[j+1] = tempValue;
                            ok = true;
                        }
                    }
                     if(ok == false)
                         break;
                }

        for(i = 0 ; i < array.length  ; i++){
        System.out.print(array[i]);
      }
        }
    }