Tensor keep_prob = Tensor.create(1.0f);
Tensor result = s.runner()
  .feed("input_tensor", image)
  .feed("Placeholder_1", keep_prob)
  .fetch("fc8/fc8")
  .run()
  .get(0);