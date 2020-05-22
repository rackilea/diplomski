Method round = Math.class.getMethod("round", double.class);
System.out.println(Arrays.toString(round.getParameterTypes()));
System.out.println(round.getReturnType() == long.class);

Method exit = System.class.getMethod("exit", int.class);
System.out.println(Arrays.toString(exit.getParameterTypes()));
System.out.println(exit.getReturnType() == void.class);