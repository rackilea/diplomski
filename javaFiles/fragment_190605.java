for(int persistRowNum=1;persitRowNum<100;persistRowNum++){
try{
    resultSet.absolute(persistRowNum);

    if((newByteArrayOne.lenght)>0){
        resultSet.updateBytes(2,newByteArrayOne);
      } else{
        resultSet.updateBytes(2,resultSet.getBytes(2));
      }

    if((newByteArrayTwo.length)>0){
       resultSet.updateBytes(3,newByteArrayTwo);
    } else{
        resultSet.updateBytes(3,resultSet.getBytes(3));
    }

    resultSet.updateRow();

   }catch(SQLException e){
     return;
   }
}