List<Object[]> r = new ArrayList<Object[]>();
List r2 = r; // Because generics are "imaginary" we can fake this,
             // but the compiler WILL GENERATE A WARNING at type information loss
r2.add(1.2); // Now we add a Double (to r since r2 is r)

// CC! - Have a Double where Object[] was expected
Object[] res = (Object[])r.get(0);