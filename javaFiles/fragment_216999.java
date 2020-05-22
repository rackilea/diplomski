public static Employee[] assignEmployeeNum(Employee[] list, String[] number){
    for(int i = 0; i<list.length; i++){
       list[i].setEmployeeNumber(number[i]);
    }   
     return list;    
 }