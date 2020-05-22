@Configuration
class RobotConfig {

    @Bean @Scope(SCOPE_PROTOTYPE)
    public RobotFactory robotFactory() {
        return new RobotFactory() {

            @Override
            public Robot newRobot(String name) {
                return new RobotImpl(name, r2dxBrain());
            }
        };
    }

    @Bean @Scope(SCOPE_PROTOTYPE)
    public Brain r2dxBrain() {
        return new RobotBrain();
    }
}