Employee employees[] = new Employee[100];
// fill the array
for (Employee currentEmployee : employees) {
    if (currentEmployee != null) {
        // process currentEmployee
    }
}
// or using continue to avoid undue nesting/indentation
for (Employee currentEmployee : employees) {
    if (currentEmployee == null)
        continue;
    // process currentEmployee
}