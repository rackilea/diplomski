String[] arr = {"aa-bb-cc","dd-bb-ee","aa-hh-gg"};      
for(int i=0;i<arr.length;i++){          
newArr =  arr[i].split("-");                                                            
appList.add(newArr[0]);               
prodList.add(newArr[1]);                 
rolList.add(newArr[2]);        
}