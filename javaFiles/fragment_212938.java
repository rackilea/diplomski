// String nullStr = null;

  nullStr ----------> X    pointing to nothing



  // String emptyStr = "";
                      +------------------+
  emptyStr ---------> |       String     |
                      +------------------+
                      | length = 0       |
                      | content = []     |
                      +------------------+


  // String myStr = "ab";
                      +------------------+
  myStr ------------> |       String     |
                      +------------------+
                      | length = 2       |
                      | content = [ab]   |
                      +------------------+