try {
    SearchData searchData = searchService.find(query);
    request.setAttribute("searchData", searchData);
} catch (SomeException e) {
    request.setAttribute("error", "Sorry, search failed. Please try again.");
}

request.getRequestDispatcher("/WEB-INF/searchResult.jsp").forward(request, response);