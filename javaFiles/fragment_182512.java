} catch (IOException e) {
    // it seems the website is not reachable or the content is not according to the expectations.
    System.err.println("website not reachable or content malformed");
    // you may need to set the result1, result2, result3 variables accordingly here
    amazon1.rsult1 = 0;
    amazon1.rsult2 = 0;
    amazon1.rsult3 = 0;
    return;
}