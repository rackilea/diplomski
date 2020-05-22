Iterator<Employee> iterator = data.getEmployees().iterator();
while (iterator.hasNext()) {
    if (removeId.equals(iterator.next().getId())) {
         iterator.remove();
    }
}