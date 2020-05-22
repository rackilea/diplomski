# Changed addInput(x) to addInput(xVar)
Operation xUpdateOp =
    g.opBuilder("AssignAdd", "x_get_x_plus_step").addInput(xVar).addInput(step).build();

try (Session s = new Session(g)) {
  # Initialize the variable once
  s.runner().addTarget(x.op()).run();
  s.runner().addTarget(xUpdateOp).run();
  s.runner().addTarget(xUpdateOp).run();
  s.runner().addTarget(xUpdateOp).run();

  try (Tensor<Float> result =
       s.runner().fetch(xUpdateOp.name(), 0).run().get(0).expect(Float.class)) {
    System.out.println(result.floatValue());
  }                     
}