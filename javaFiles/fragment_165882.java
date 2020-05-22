public class Main {
    public static void main(String[] args) {
        Automovel arrayteste[] = new Automovel[2];
        Motor motor;

        motor = new MotorEletrico(5, 10);
        arrayteste[0] = new Automovel("Opel", "xx-12-xx", "2000", motor, 2000);

        motor = new MotorCombustao(7, 4, "xx-yy-zz");
        arrayteste[1] = new Automovel("Opel", "xx-08-xx", "1995", motor, 1995);

        for (Automovel automovel : arrayteste) {
            motor = automovel.getMotor();
            if (motor instanceof MotorEletrico) {
                System.out.println(((MotorEletrico) motor).getAutonomia());
            }
            if (automovel.getMotor() instanceof MotorCombustao) {
                System.out.println(((MotorCombustao) motor).getCilindrada());
                System.out.println(((MotorCombustao) motor).getCombustivel());
            }
        }
    }
}