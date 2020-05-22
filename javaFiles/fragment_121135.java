public class PowerUpUser {
    private PowerUpType powerUpType;

    public PowerUpUser(PowerUpType powerUpType) {
        this.powerUpType = powerUpType;
    }

    public void usePowerUp() {
        // this replaces the switch statement
        powerUpType.execute(this);
    }

    private void logicForPowerUp1() {

    }

    private void logicForPowerUp2() {

    }

    private enum PowerUpType {
        PowerUp1 {
            @Override
            public void execute(PowerUpUser powerUpUser) {
                powerUpUser.logicForPowerUp1();
            }
        },
        PowerUp2 {
            @Override
            public void execute(PowerUpUser powerUpUser) {
                powerUpUser.logicForPowerUp2();
            }
        };

        public abstract void execute(PowerUpUser powerUpUser);
    }
}