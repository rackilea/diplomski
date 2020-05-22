TopsCollection<String> tc = new TopsCollection<>();
tc.add(12, "nome4");
tc.add(1, "nome1");
tc.add(4, "nome3");
tc.add(4, "nome2");

List<String> tops = tc.getTops(2); // contains 3 elements: nome4, nome3, nome2