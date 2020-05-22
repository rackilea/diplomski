class Main {
    public static void roll(String s, int depth) {
        if(depth == 0)
            System.out.println(s.substring(1));
        else
            for(int i = 0; i <= 6; i++)
                roll(s + "," + i, depth - 1);
    }
    public static void main(String[] args) {
        roll("", 6); //2nd parameter > 0
    }
}