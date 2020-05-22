import jess.*;
    // ...

    // Get Jess ready
    Rete engine = new Rete();
    engine.batch("dates.clp");
    engine.watchAll();

    // Plug in the "chosen date"
    Date chosenDate = new Date(113, 4, 5);
    Fact fact = new Fact("chosendate", engine);
    fact.setSlotValue("__data", new Value(new ValueVector().add(chosenDate), RU.LIST));
    engine.assertFact(fact);

    // Run the rule and report the result
    int count = engine.run();
    if (count > 0) {
        int score = engine.getGlobalContext().getVariable("*var*").intValue(null);
        System.out.println("Score = " + score);
    } else {
        System.out.println("No matching date found.");
    }