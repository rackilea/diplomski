public static Result show(String page) {

    File htmlFile = new File(page+".html");
    if (!htmlFile.exists()) htmlFile = new File("home.html");

    return ok(htmlFile).as("text/html");
}