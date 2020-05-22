for (int i = 0; i < arrayteste.length; i++) {
    if (arrayteste[i] != null) {
        motor = arrayteste[i].getMotor();
        if (motor instanceof MotorEletrico) {
            System.out.println(((MotorEletrico) motor).getAutonomia());
        }
        if (arrayteste[i].getMotor() instanceof MotorCombustao) {
            System.out.println(((MotorCombustao) motor).getCilindrada());
            System.out.println(((MotorCombustao) motor).getCombustivel());
        }
    }
}