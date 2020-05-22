@GetMapping(value = "/test")  // just for samples 
  public String getLinkToFile() throws Exception {
    String body =
        "<HTML><body> <a href=\"https://file-examples.com/wp-content/uploads/2017/02/file_example_CSV_5000.csv\">Link clik to go</a></body></HTML>";
    return (body);

  }