public class SO1 {

    int agentCount = 1;
    int resourceCount = 1;
    int[][] resourcesHeld = new int[agentCount][resourceCount];

    public void resourceConsumption() {
        for (int i = 0; i < agentCount; i++) {
            for (int j = 0; j < resourceCount; j++) {
                resourcesHeld[i][j] = resourcesHeld[i][j] * 3 / 4;
            }
        }
    }

    public static void main(String[] args) {
        SO1 s = new SO1();

        s.resourcesHeld[0][0] = 4000;
        s.resourceConsumption();
        System.err.println(s.resourcesHeld[0][0]); // 3000
    }
}