Prolog engine = new Prolog();
Theory theory = new Theory(new FileInputStream("theory.pl"));
engine.setTheory(theory);
SolveInfo solution = engine.solve("associatedWith(X, Y, Z).");
if (solution.isSuccess()) {
    System.out.println(solution.getTerm("X"));
    System.out.println(solution.getTerm("Y"));
    System.out.println(solution.getTerm("Z"));
}