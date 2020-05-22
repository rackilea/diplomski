public class Test {

        public class Teacher {

            String firstName;
            String lastName;
            String rank;
            Double salary;

            public Teacher(String firstName, String lastName, String rank,
                    Double salary) {
                super();
                this.firstName = firstName;
                this.lastName = lastName;
                this.rank = rank;
                this.salary = salary;
            }

        }

        ArrayList<Teacher> result = new ArrayList<Teacher>();

        public static void main(String[] args) throws MalformedURLException {
            Test u = new Test();
            u.read();
            u.printAverages();
        }

        private void printAverages() {
            Iterator<Teacher> iterator = result.iterator();
            double assistantHolder = 0, assistantCounter = 0, 
                   assosiatedHolder = 0, assosiatedCounter = 0,
                   fullHolder = 0, fullCounter = 0;
            while (iterator.hasNext()) {
                Teacher teacher = iterator.next();
                if (teacher.rank.equals("associate")) {
                    assosiatedHolder += teacher.salary;
                    assosiatedCounter++;
                } else if (teacher.rank.equals("assistant")) {
                    assistantHolder += teacher.salary;
                    assistantCounter++;
                } else if (teacher.rank.equals("full")) {
                    fullHolder += teacher.salary;
                    fullCounter++;
                }
            }
            System.out.println("Associate average:"+(assosiatedHolder/assosiatedCounter));
            System.out.println("Assistant average:"+(assistantHolder/assistantCounter));
            System.out.println("Full average:"+(fullHolder/fullCounter));
        }

        private ArrayList<Teacher> read() throws MalformedURLException {
            URL data = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
            try {
                Scanner scan = new Scanner(data.openStream());
                while (scan.hasNext()) {
                    String line = scan.nextLine();
                    String[] tokens = line.split("\\s+",4);
                    String firstName = tokens[0], lastName = tokens[1], rank = tokens[2];
                    Double salary = Double.valueOf(tokens[3]);
                    result.add(new Teacher(firstName, lastName, rank, salary));
                }
                scan.close();
                return result;
            } catch (IOException e) {
                e.getStackTrace();
            }
            return result;
        }
    }