for(i=0;i<startIndex.length+1;){

      case 2:
         outPut += ip.substring(startIndex[i] - 1, startIndex[i]);
         outPut += ip.substring(startIndex[i], ip.length());

         break;
    }

change with it  

 for (i = 0; i < startIndex.length + 1;i++) {    
       case 2:
         outPut += ip.substring(startIndex[i] - 1, startIndex[i]);
         outPut += ip.substring(startIndex[i], ip.length());
         i++;
         break;

        }