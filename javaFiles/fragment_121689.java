package com.vkg;

import java.util.Arrays;
import java.util.Scanner;

public class Department {

    public static void main(String[] args) {
        Department department = new Department();
        Scanner in = new Scanner(System.in);
        System.out.println("How many employees?\n");
        int noOfEmployees = in.nextInt();
        Employee[] employees = new Employee[noOfEmployees];

        for (int i = 0; i < employees.length; i++) {
            Employee employee = department.new Employee();
            System.out.print("Enter employee name: ");
            String employeeName = in.next();
            employee.setName(employeeName);

            System.out.print("Enter employee age: ");
            int age = in.nextInt();
            employee.setAge(age);

            employees[i] = employee;
        }
        Arrays.sort(employees);

        for (Employee employee : employees) {
            System.out.println(employee.getName() + "'s age = " + employee.getAge());
        }
    }

    public class Employee implements Comparable<Employee> {
        private String name;
        private int age;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public int compareTo(Employee o) {
            if(this == o || this.age == o.age) {
                return 0;
            } else if (this.age < o.age) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}