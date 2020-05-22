try {
    throw SubTypeOfException(...);
} catch(Exception e) {
    ... block 1 ...
} catch(SubTypeOfException e) {
    ... block 2 ...
}