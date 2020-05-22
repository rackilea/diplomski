public void getDetailedItem(){
        FeedParser parser=new FeedParser();
        try{
           mItem=parser.parseDetailed();
        }catch(Exception e){
           mItem = null;
        }
}