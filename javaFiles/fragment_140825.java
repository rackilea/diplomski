import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class ClassMatcher {

        //The set of all possible matchings.
    static ArrayList<ArrayList<Pair>> set = new ArrayList<ArrayList<Pair>>(); 
        // The current matching being built
    static ArrayList<Pair> cur = new ArrayList<Pair>();

    public static void main(String[] args) {

        Lecture[] l = { new Lecture(50, 1), new Lecture(70, 2), new Lecture(50, 3)};
        ArrayList<Classroom> c = new ArrayList<>(Arrays.asList(
            new Classroom(50, 1), new Classroom(70, 2),
            new Classroom(100, 3)));

        for (int i = 0; i < l.length; i++) {
                    //Fill with dummy values
            cur.add(new Pair(new Classroom(-1, -1), new Lecture(-1, -1)));
        }

        // Sort the arrays to save work in rec()
        Arrays.sort(l);
                //Sort classrooms in descending order
        Collections.sort(c, new Comparator<Classroom>() {
            @Override
            public int compare(Classroom o1, Classroom o2) {
                return o1.compareTo(o2) * -1;
            }
        });

        recursive(l, c, 0);

        // Print all the sets
        for (int i = 0; i < set.size(); i++) {
            System.out.print("{");
            for (int j = 0; j < set.get(i).size(); j++) {
                System.out.print("Lecture " + set.get(i).get(j).l + ": "
                    + "Classroom " + set.get(i).get(j).c);
                if (j < set.get(i).size() - 1) {
                    System.out.print(", ");
                } else {
                    System.out.print("}");
                }
            }
            System.out.println();
        }

    }

    public static void recursive(Lecture[] lectureList,
            ArrayList<Classroom> classroomList, int curLecture) {

        for (int i = 0; i < classroomList.size(); i++) {
            // if the classroom is smaller than the lecture we cna stop as the
            // lists are sorted so all other lectures will be to big for the
            // current classroom
            if (lectureList[curLecture].size > classroomList.get(i).size) {
                return;
            }

            //Match the current classroom to the current lecture and add to the working matching
            cur.set(curLecture, new Pair(classroomList.get(i), lectureList[curLecture]));

                //If there are more lectures to do then remove the used classroom and recursively call.
            if (curLecture < lectureList.length - 1) {
                Classroom tmp = classroomList.remove(i);
                recursive(lectureList, classroomList, curLecture + 1);
                classroomList.add(i, tmp);
            } 
                // If no Lectures left then add this matching to the set of all matchings. 
            else {
                ArrayList<Pair> copy = (ArrayList<Pair>) cur.clone();
                set.add(copy);
            }
        }

    }

}

class Classroom implements Comparable<Classroom> {

    int size;
    int number;

    public Classroom(int s, int n) {
        size = s;
        number = n;
    }

    @Override
    public int compareTo(Classroom o) {

        return Integer.compare(this.size, o.size);
    }

    public String toString() {
        return number + " (" + size + ")";
    }
}

class Lecture implements Comparable<Lecture> {

    int size;
    int number;

    public Lecture(int s, int n) {
        size = s;
        number = n;
    }

    @Override
    public int compareTo(Lecture o) {

        return Integer.compare(this.size, o.size);
    }

    public String toString() {
        return number + " (" + size + ")";
    }
}

class Pair {

    Classroom c;
    Lecture l;

    public Pair(Classroom c, Lecture l) {
        this.c = c;
        this.l = l;
    }
}