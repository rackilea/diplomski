try {
     mTextView.setText("Response is: "+ response.substring(0,500));
} catch (IndexOutOfBoundsException e) {
    e.printStackTrace();
    System.out,println("Invalid indexes or empty string");
}
  catch (NullPointerException e) { // mTextView or response can be null 
    e.printStackTrace();
    System.out,println("Something went wrong ,missed initialization");
}
catch (Exception e) {  
    e.printStackTrace();
    System.out,println("Something unexpected happened , move on or can see stacktrace ");
}