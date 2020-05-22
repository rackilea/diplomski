package com.example.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class GetFileLastModifiedExample
{
    public static void main(String[] args)
    {   
    File file = new File("\\somefile.txt");

    System.out.println("Before Format : " + file.lastModified());

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("After Format : " + sdf.format(file.lastModified()));
    }
}