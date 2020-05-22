import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class RecordParser {

    private BufferedReader reader;

    private List<Person> people;

    private List<String> output;

    public RecordParser(BufferedReader reader) {
        this.reader = reader;
        this.people = new ArrayList<Person>();
        this.output = new ArrayList<String>();
    }

    public void execute() throws IOException {
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" , ");
            addPerson(new Person(parts[0]));
            if ((parts[1].contains("-in-")) && (parts[1].contains("-out-"))) {
                String[] inout = parts[1].split("-out-");
                Person person = getPerson(parts[0]);
                person.setInTime(inout[0]);
                person.setOutTime("-out-" + inout[1]);
            } else if (parts[1].contains("-in-")) {
                Person person = getPerson(parts[0]);
                person.setInTime(parts[1]);
            } else {
                Person person = getPerson(parts[0]);
                person.setOutTime(parts[1]);
            }
        }

        // Output the people to the String list
        for (Person p : people) {
            output.add(p.getPerson());
        }
    }

    private void addPerson(Person person) {
        for (Person p : people) {
            if (p.getNameDate().equals(person.getNameDate())) {
                return;
            }
        }
        people.add(person);
    }

    private Person getPerson(String nameDate) {
        for (Person p : people) {
            if (p.getNameDate().equals(nameDate)) {
                return p;
            }
        }
        return null;
    }

    public List<String> getOutput() {
        return output;
    }

    public static void main(String[] args) {
        String input = "02,-\"sangeetha-May 02, 2013 , -in-09:48:06:61\n" +
                "01,-\"lohith-May 01, 2013 , -out-09:10:41:61\n" +
                "02,-\"sushma-May 02, 2013 , -in-09:48:06:61\n" +
                "01,-\"sushma-Jan 01, 2013 , -in-09:07:06:50-out-05:39:01:63\n" +
                "02,-\"sangeetha-May 02, 2013 , -out-08:08:19:27\n" +
                "02,-\"sushma-May 02, 2013 , -out-07:52:13:51\n" +
                "03,-\"lohith-May 03, 2013 , -in-11:39:44:08";

        BufferedReader reader = new BufferedReader(new StringReader(input));
        RecordParser recordParser = new RecordParser(reader);

        try {
            recordParser.execute();

            for (String s : recordParser.getOutput()) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Person {
        private String nameDate;
        private String inTime;
        private String outTime;

        public Person (String nameDate) {
            this.nameDate = nameDate;
            this.inTime = "missing in";
            this.outTime = "missing out";
        }

        public void setInTime(String inTime) {
            this.inTime = inTime;
        }

        public void setOutTime(String outTime) {
            this.outTime = outTime;
        }

        public String getNameDate() {
            return nameDate;
        }

        public String getPerson() {
            StringBuilder builder = new StringBuilder();
            builder.append(nameDate);
            builder.append(" , ");
            builder.append(inTime);
            builder.append(" , ");
            builder.append(outTime);
            return builder.toString();
        }

    }

}