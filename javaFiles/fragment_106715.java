class ListData {
   int listNumber;
   String listData1;
   String listData2;

   ListData(int listNumber, String listData1, String listData2) {
      this.listNumber = listNumber;
      this.listData1 = listData1;
      this.listData2 = listData2;
   }

   @Override
   public String toString(){
       return listNumber + "-" + listData1 + ":" + listData2;
   }
}