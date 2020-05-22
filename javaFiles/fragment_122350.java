public class MachinePauseTransitionManager {

    private static final Map<Machine, PauseTransition> MACHINE_PAUSE_TRANSITIONS = new HashMap<> ();

    public void createPauseTransition(Machine machine) {
        PauseTransition resetCredentialsMachine = new PauseTransition(Duration.minutes(2));
        resetCredentialsMachine.setOnFinished(e -> expireCredentialsForMachine(machine));
        MACHINE_PAUSE_TRANSITIONS.put(machine, resetCredentialsMachine)
    }

    public void login(Machine machine) {
        MACHINE_PAUSE_TRANSITIONS.get(machine).playFromStart();
    }
}