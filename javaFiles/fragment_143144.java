public class LeapYearTest {
    public static void main(String[] args) {
        LeapYearTest leapYearTest = new LeapYearTest();
        leapYearTest.showLeapYears(2000, 2020);
        leapYearTest.showLeapYears(2000, 2000);
    }

    private void showLeapYears(int start, int end) {
        StringBuffer msg = new StringBuffer();
        if (start < end) {
            msg.append("<html><table><tr><td><b>Leap Years</b></td></tr>");
            for (int i = start; i < end; i++) {
                if(i % 400 == 0 || i % 4 == 0) {
                    msg.append("<tr><td>" + i + "</td></tr>");
                }
            }
            msg.append("</table></html>");
        } else {
            msg.append("Error: Starting Year is greater than Ending Year!");
        }

        JOptionPane.showMessageDialog(null, msg.toString());
    }
}