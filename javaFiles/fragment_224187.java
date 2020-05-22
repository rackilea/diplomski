import java.util.ArrayList;
    import java.util.List;
    import java.util.StringTokenizer;

    class Student {
        private String identifcation;

        @Override
        public String toString() {
            return "Student{" +
                    "identifcation='" + identifcation + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", labs=" + labs +
                    ", project=" + project +
                    ", test=" + test +
                    '}';
        }

        private String firstName;
        private String lastName;
        private List labs;
        private List project;
        private List test;

        public Student(String identifcation, String firstName, String lastName, List<Integer> labs, List<Integer> projects, List<Integer> test) {
            this.identifcation = identifcation;
            this.firstName = firstName;
            this.lastName = lastName;
            this.labs = labs;
            this.project = projects;
            this.test = test;
        }

    }

    public class Main {
        public static void main(String[] args) {
            String line = "example ID,First Name,Last Name,10,10,10,,100,100,,100";
            StringTokenizer tokenizer = new StringTokenizer(line,",");
            while(tokenizer.hasMoreElements()) {
                String id = tokenizer.nextToken();
                String fname = tokenizer.nextToken();
                String lName = tokenizer.nextToken();

                List<Integer> labs = new ArrayList<Integer>(){{
                    add(Integer.parseInt(tokenizer.nextToken()));
                    add(Integer.parseInt(tokenizer.nextToken()));
                    add(Integer.parseInt(tokenizer.nextToken()));
                }};

                List<Integer> project = new ArrayList<Integer>(){{
                    add(Integer.parseInt(tokenizer.nextToken()));
                    add(Integer.parseInt(tokenizer.nextToken()));
                }};

                List<Integer> test = new ArrayList<Integer>(){{
                    add(Integer.parseInt(tokenizer.nextToken()));
                }};
                Student s1 = new Student(id,fname,lName,labs,project,test);

                System.out.println(s1.toString());
            }
        }
    }