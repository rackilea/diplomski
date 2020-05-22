class Star {
    int x, y;

    public Star(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {
    public static void main(String[] args) {
        Star s1 = new Star(0, 0);
        Star s3 = new Star(0, 0);
        Star s2 = new Star(31, -31*31);
        Set<Star> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println(set.size());
    }
}