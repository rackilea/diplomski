while (keyboard.hasNextDouble()) {
      nums.add(keyboard.nextDouble());
  }
  keyboard.close();
  System.out.println(nums);
  double sum = 0;
  for (int i = 0; i < nums.size(); i++) {
   sum += nums.get(i);
  }
  System.out.println(sum);