public abstract void solve();

public void solveProblem() {
    startTime();
    solve();
    endTime();
    System.out.println(timeTaken);
}