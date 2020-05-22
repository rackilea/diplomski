@GetMapping("/{area}/{subarea}")
    public String getFlight(MyModel model) {
      System.out.println(model);

        return "success";
    }