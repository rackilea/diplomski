// Java 5:
Box<Map<String, List<Integer>> box = new BoxImpl<Map<String, List<Integer>>();
// with static inference
Box<Map<String, List<Integer>> box = BoxImpl.make();
// with diamond operator - Java7
Box<Map<String, List<Integer>> box = new BoxImpl<>();