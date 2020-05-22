for (Iterator<String> i = list.iterator(); i.hasNext(); ) {
    String st = i.next();
    if (st.equalsIgnoreCase("str3")) {
        // Remove the element that the iterator is currently pointing to
        i.remove();
    }
}