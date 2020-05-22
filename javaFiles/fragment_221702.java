int count = 0;
while (results.hasMoreElements()) {
    count ++;
    searchResult = (SearchResult) results.nextElement();
}

System.out.println("Total number of search results = " + count);