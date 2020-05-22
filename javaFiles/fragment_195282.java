Map<Student, Set<Payment>> studentPayments =new HashMap<Student, Set<Payment>>();

public void addStudentPayment(Student student, Payment payment) {

    if (!studentPayments.containsKey(student))
        studentPayments.put(student, new HashSet<Payment>());

    if (studentPayments.get(student).add(payment))
        System.out.println("Payment was added");
    else
        System.out.println("Duplicate found. Payment not added.");
}