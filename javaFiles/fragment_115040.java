package com.compay.jasper;

import com.company.domain.Student;

public class JRDataSourceFactory {
    public static Collection<Student> createCollection() {
        return Arrays.asList( new Student() );
    }
}