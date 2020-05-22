class PoolTask {
    public static void main(String[] args) {
        double V = 200;
        double P1 = 150;
        double P2 = 170;
        double H = 2.0;

        double P1w = P1 * H;
        double P2w = P2 * H;
        double Pt = P1w + P2w;

        if(Pt <= V) {
            double percentage1 = (Pt * 100 / V);
            double percentage2 = (P1w * 100 / Pt);
            double percentage3 = (P2w * 100 / Pt);
            System.out.println("The pool is " + percentage1 + "% full. Pipe 1: " + percentage2 + "%. Pipe 2: " + percentage3 + "%.");             
        } else if (Pt > V) {
            double liters = (Pt - V);
            System.out.println("For " + H + " hours the pool overflows with " + liters + " liters");
        } else {
            System.out.println("");
        }
    }
}