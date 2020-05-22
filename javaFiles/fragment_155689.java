try{
    Document document = getWikiDocumentByKeyword("Coffee");
} catch(Exception ex){
    // Trouble connecting, handle the exception however you want.
    System.out.println(ex);
}