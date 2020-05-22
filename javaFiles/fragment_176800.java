public class PathScore {
    public String Path;
    public int Score;
}

public class Systempaths {
    public static void main(String[] args) {
        new Systempaths();
    }

    public Systempaths() {
        String[] paths = new String[5];
        paths[0] = "C:\\System\\local\\something\\anything";
        paths[1] = "C:\\System\\local\\anywhere\\somewhere";
        paths[2] = "C:\\System\\local";
        paths[3] = "C:\\System\\";
        paths[4] = "C:\\something\\somewhere";

        String ref = "C:\\System\\local\\test\\anything";
        String[] reference = ref.split("\\\\");

        List<PathScore> scores = new ArrayList<>();

        for (String s : paths) {
            String[] exploded = s.split("\\\\");
            PathScore current = new PathScore();
            current.Path = s;
            for (int i = 0; i < exploded.length; i++) {
                if (exploded[i].equals(reference[i])) {
                    current.Score = i + 1;
                } else {
                    // Punishment for paths that exceed the reference path (1)
                    current.Score = i - 1;
                    break;
                }
            }

            scores.add(current);
        }

        for (PathScore ps : scores) {
            System.out.printf("%s:\t%d\n", ps.Path, ps.Score);
        }
    }
}