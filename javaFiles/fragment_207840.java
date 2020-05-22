Employee[] employees = new Employee[first_name.length];

for (int i = 0; i < first_name.length; i++)
{
   employees[i] = new Employee(first_name[i] + " " + last_name[i], unit[i], phone_number[i]);
}