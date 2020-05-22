try {
    set.add(test2.solve(1000, func, i, i+1));
}
catch (NoBracketingException e) {
    System.err.println("Oops - error.  Likely cause: No root in interval ["+i+","+(i+1)+"]");
    System.err.println(e.message());
}