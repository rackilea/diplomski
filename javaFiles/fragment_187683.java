import java.util.*;



public class Library 
{


public static void main(String[] args) 
{

String serialNumber, title, author;


Scanner input = new Scanner(System.in);


System.out.print("Please enter the serial number: ");
serialNumber = input.next();

System.out.print("Please enter the title: ");
title= input.next();

System.out.print("Please enter the author: ");
author = input.next();

Manual man= new Manual(serialNumber,title,author);

man.print();


}


}