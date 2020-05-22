public class StudentQuiz {

    public StudentQuiz() {
        Map<String, List<QuizResult>> students = processStudentQuizes();
        // Go through the keys of the map (which is the name of students)
        for(String student : students.keySet()) {
            // Get all the quiz results of the student
            List<QuizResult> results = students.get(student);
            System.out.println(student + " ");
            for(QuizResult result : results) {
                // Print the quiz type and the score
                System.out.println(result.getQuizType().name() + " " + result.getScore());
            }
        }
    }

    private Map<String, List<QuizResult>> processStudentQuizes() {
        Map<String, List<QuizResult>> students = new TreeMap<>();

        System.out.println("Add student");
        Scanner s = new Scanner(System.in);

        String answer = null;
        while(!"n".equalsIgnoreCase(answer)) {
            System.out.println("Student Name");
            String studentName = s.next();

            System.out.println("Quiz Name");
            String quizName = s.next();

            // Check if the quiz type actually exist
            boolean quizTypeOk = false;
            for(QuizType type : QuizType.values()) {
                if(type.name().equalsIgnoreCase(quizName)) {
                    // We found the quiz type, so we can break from this loop
                    quizTypeOk = true;
                    break;
                }
            }

            if(!quizTypeOk) {
                // Quiz type couldn't be found, so print the message and start the while loop again
                System.out.println("No such type of quiz! Please start again!");
                continue;
            }

            System.out.println("Average Score");
            double avgScore = s.nextDouble();

            // Now we can create a QuizResult object from the inputed data
            QuizResult result = new QuizResult(QuizType.valueOf(quizName), avgScore);

            // Check if the student already exist
            if(students.containsKey(studentName)) {
                // Add a new result to the list of results for the already existing student
                students.get(studentName).add(result);
            }
            else {
                // Create a new student in the map with a new results list and put the result into the list
                List<QuizResult> results = new ArrayList<>();
                results.add(result);
                students.put(studentName, results);
            }

            System.out.println("Add another Student Y/N");
            answer = s.next();
        }
        s.close();
        return students;
    }

    public static void main(String[] args) {
        new StudentQuiz();
    }
}