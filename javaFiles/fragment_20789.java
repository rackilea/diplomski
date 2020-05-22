State one = new State("one");
State two = new State("two");
State three = new State("three");

Condition sunday = new Condition("Sunday");
Condition raining = new Condition("Raining");
Condition notSunday = new Condition("Not Sunday");
Condition notRaining = new Condition("Not Raining");

List<Transition> transitions = new ArrayList<Transition>();
transitions.add(one, new Set(sunday), three);
transitions.add(one, new Set(sunday), two); // <<--- Invalid, cant go to two and three
transitions.add(one, new Set(raining), three);
transitions.add(one, new Set(sunday, raining), three);
transitions.add(one, new Set(notSunday, notRaining), three);

StateMachine machine = new StateMachine(one, transitions);
System.out.print(machine.current); // "one"
machine.apply(new Set(sunday, raining));
System.out.print(machine.current); // "three