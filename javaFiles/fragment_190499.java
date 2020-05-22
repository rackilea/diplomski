@Before
public void setUp() throws Exception {
    underTest = new MyClass() {
        @Override
        public ArkSolver acquireSolver() {
            return <your mock here>;
        }
    };
}