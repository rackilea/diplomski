Request request = ...
Categories.CategoryFilter filter =
    Categories.CategoryFilter.include(
        testutils.SlowTests.class); 
request = request.filterWith(filter);
Result result = JUnitCore.run(request);