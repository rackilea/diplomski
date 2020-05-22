try{

  Cursor cursor = 
         database.query(DBHelper.ASSIGNMENT_ORDER_DETAIL,allAssignemntOrderDetail,
         DBHelper.ASSIGNMENT_ID +"= 'assgn1' and "+DBHelper.ORDER_ID +"= 'ord1'", 
         null, null, null, null);

   if(cursor != null) {
       cursor.moveToFirst();
       AssignmentOrderDetail =
            cursor.getString(cursor.getColumnIndex(DBHelper.PRODUCT_MODULE_ID));
   }
   return AssignmentOrderDetail;
}finally {
     cursor.close();
}