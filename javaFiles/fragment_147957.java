import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;

    import javax.swing.JOptionPane;

    public class Customer
    {

        private final String firstName;

        private final String lastName;

        private final String address;

        private final int    age;

        private final int    id;

        public Customer(String firstName, String lastName, String address, int age,
                int id)
        {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.age = age;
            this.id = id;
        }

        @Override
        public String toString ()
        {
            return "Customer [firstName=" + firstName + ", lastName=" + lastName
                    + ", address=" + address + ", age=" + age + "]";
        }

        public static void main (String[] args)
        {

        }

        public void writetofile (String custname, String custlname, int agee,
                String address, int age)
        {

            Customer customer = new Customer(custname, custlname, address, age, id);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "records.txt", true)))
            {
                String s = customer.toString();
                bw.write(s);
                bw.newLine();
                bw.flush();
            }

            catch (IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Error In File");
            }
        }

    }