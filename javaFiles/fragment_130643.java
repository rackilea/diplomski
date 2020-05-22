MainHomePage pageApp; // Declare here but do not assign

String pageValue=request.getParameter("page");
if((pageValue!=null) && (pageValue.compareTo("1")==0)) {
    pageApp = new MainHomePage(session);
} else if((pageValue!=null) && (pageValue.compareTo("2")==0)) {
    pageApp = new MainAffittaAppartamenti(session);
} else {
    pageApp = new MainHomePage(session);
}

pageApp.someMethod();