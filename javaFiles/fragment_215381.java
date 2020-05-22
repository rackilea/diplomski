Example<Integer> example = new Example<Integer>();
example.value = Integer.valueOf(0);
// set holder.held
holder.held = example;
// get holder.held, but we lose some type information
Example<? extends Number> example = holder.held;
// access and use a member of the Example
Number number = example.value;
System.out.println(number.intValue());