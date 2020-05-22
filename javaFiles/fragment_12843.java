if (hoursWorked > 37.5f) {
    basePay = 37.5f*ratePay;
    overtimePay = (hoursWorked - 37.5f) * ratePay * 1.5f;
} else {
    basePay = hoursWorked * ratePay;
    overtimePay = 0.0f;
}