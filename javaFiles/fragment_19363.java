String[] strings = request.getParameterValues("multi");
if (strings != null) {
    for (String s: strings) {
        // special characters in variable s do not appear correctly
    }
}