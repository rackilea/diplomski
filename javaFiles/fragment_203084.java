myActivity implements fragmentCallback{
     public boolean onQuoteDeleted(Quote deletedQuote){
         if(myQuotelist.contains(deleteQuote){
              myQuoteList.remove(deleteQuote);
              adapter.notifyDataSetChanged();
         }
     }
}