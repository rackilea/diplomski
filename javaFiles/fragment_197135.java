please find code here - 

    /*--------------- FinalProject Class Begin ------------ */
    package teststack;

    public class FinalProject

    {

    //------------------------------- Attributes --------------------------------

    public String name;
    public double cout;
    public int choice;
    public Double temp;
    public Double salary;
    public  Double salary2;
    public  Double salary3;  
    public Double share;
    public Double hdmf;
    public Double sss;
    public Double tax;
    public Double basicsalary;
    public Double netpay;

    //------------------------------- Constructor --------------------------------

    public FinalProject (){

    this.name="";
    this.cout=0.0;
    this.temp=0.0;
    this.choice = 0;
    this.basicsalary = 0.0;
    this.salary=0.0;
    this.salary2=salary;
    this.salary3=0.0;
    this.share=0.0;
    this.hdmf=0.0;
    this.sss=0.0;
    this.tax=0.0;   
    this.netpay = 0.0;
    }  

    //------------------------------- Setter --------------------------------

    public void setName(String name){

    this.name=name;

    }

    public void setCout(Double salary){

    if (salary < 30000.00){
          System.out.print("\n ----------------- \n RESULT:"); 
       System.out.print("\nYour Position is Staff" + "\n");
    }

    else if (salary >= 30000.00 && salary <= 49999.00){
          System.out.print("\n ----------------- \n RESULT:"); 
        System.out.print("\nYour Position is Supervisor"+ "\n");
    }

    else if (salary >= 50000.00 && salary <= 79999.00){
          System.out.print("\n ----------------- \n RESULT:"); 
        System.out.print("\nYour Position is Manager"+ "\n");
    }

     else if (salary >= 80000.00 && salary <= 100000.00){
           System.out.print("\n ----------------- \n RESULT:"); 
        System.out.print("\nYour Position is Junior Officer"+ "\n");
    }

     else if (salary > 100001.00){
           System.out.print("\n ----------------- \n RESULT:"); 
        System.out.print("\nYour Position is Senior Officer"+ "\n");
    }

    // salary = cout;

    }

    public void setChoice(int choice){

    this.choice=choice;

    }

    public void setBasicsalary(Double basicsalary){

    this.basicsalary = basicsalary;

    }

    public void setNetpay(Double netpay){

    netpay = -this.salary - this.hdmf - this.salary3 - this.tax;
            this.netpay=netpay;

    }

    public void setSalary(Double salary){

    if(salary <= 8999.99 )
        {
            salary = 100.00;

        }

    else if(salary >= 9000 && salary <= 9999.99)
    {
        salary = 112.50;

    }

    else if(salary >= 10000 && salary <= 10999.99)
    {
        salary = 125.00;

    }

    else if(salary >= 11000 && salary <= 11999.99)
    {
        salary = 137.50;

    }

    else if(salary >= 12000 && salary <= 12999.99)
    {
        salary = 150.00;

    }

    else if(salary >= 13000 && salary <= 13999.99)
    {
        salary = 162.50;

    }

    else if(salary >= 14000 && salary <= 14999.99)
    {
        salary = 175.50;

    }

    else if(salary >= 15000 && salary <= 15999.99)
    {
        salary = 187.50;

    }

    else if(salary >= 16000 && salary <= 16999.99)
    {
        salary = 200.00;

    }

    else if(salary >= 17000 && salary <= 17999.99)
    {
        salary = 212.50;

    }

    else if(salary >= 18000 && salary <= 18999.99)
    {
        salary = 225.00;

    }

    else if(salary >= 19000 && salary <= 19999.99)
    {
        salary = 237.50;

    }

    else if(salary >= 20000 && salary <= 20999.99)
    {
        salary = 250.00;

    }

    else if(salary >= 21000 && salary <= 21999.99)
    {
        salary = 262.50;

    }

    else if(salary >= 22000 && salary <= 22999.99)
    {
        salary = 275.00;

    }

    else if(salary >= 23000 && salary <= 23999.99)
    {
        salary = 287.50;

    }

    else if(salary >= 24000 && salary <= 24999.99)
    {
        salary = 300.00;

    }

    else if(salary >= 25000 && salary <= 25999.99)
    {
        salary = 312.50;

    }

    else if(salary >= 26000 && salary <= 26999.99)
    {
        salary = 325.00;

    }

    else if(salary >= 27000 && salary <= 27999.99)
    {
        salary = 337.50;

    }

    else if(salary >= 28000 && salary <= 28999.99)
    {
        salary = 350.00;

    }

    else if(salary >= 29000 && salary <= 29999.99)
    {
        salary = 362.50;

    }

    else if(salary >= 30000 && salary <= 30999.99)
    {
        salary = 375.00;

    }

    else if(salary >= 31000 && salary <= 31999.99)
    {
        salary = 387.50;

    }

    else if(salary >= 32000 && salary <= 32999.99)
    {
        salary = 400.00;

    }

    else if(salary >= 33000 && salary <= 33999.99)
    {
        salary = 412.50;

    }

    else if(salary >= 34000 && salary <= 34999.99)
    {
        salary = 425.00;

    }

    else if(salary >= 35000)
    {
        salary = 437.50;

    }

    this.salary=salary;

    } public void setSalary2(Double salary2){

    this.salary2=salary2;

    }

    public void temp(Double temp){

    this.temp=temp;

    }

    public void setSalary3(Double salary3){

     if(this.salary3 < 30000){
       salary3 = salary3 * 0.05;
    }

    else if (this.salary3 >= 30000 && this.salary3 <= 49999){
       salary3 = salary3 * 0.07;
    }

    else if (this.salary3 >= 50000 && this.salary3 <= 79999){
        salary3 = salary3 * 0.08;
    }

     else if (this.salary3 >= 80000 && this.salary3 <= 100000){
         salary3 =salary3 * 0.1;
    }

     else if (this.salary3 > 100001){
        salary3 = salary3 * 0.15;
    }


    this.salary3=salary3;

    }

    public void setShare(Double share){

    this.share=share;

    }

    public void setTemp(Double temp){

    this.temp=temp;

    }

    public void setHdmf(Double hdmf){

    if(hdmf > 100){
            System.out.print("Prefered HDMF value has been entered" + "\n");

              this.hdmf = hdmf;

        }
        else if(hdmf == 0){
            System.out.print("Default has been chosen to deduct 100 HDMF" + "\n");
            salary2 = 100.00;
             this.hdmf = salary2;
        }

    }

    public void setSss(Double sss){

    this.sss = sss * 0.50;   

    }

    public void setTax(Double tax){

    this.tax = tax * 0.50;

    }

    //getter

    public String getName(){

    return this.name;

    }

    public Double getCout(){

    return this.cout;

    }

    public int getChoice(){

    return this.choice;

    }

    public Double getBasicsalary(){

    return this.basicsalary;

    }

    public Double getNetpay(){

    return this.netpay;

    }

    public Double getSalary(){

    return this.salary;

    }

    public Double getTemp(){

    return this.temp;

    }

    public Double getSalary2(){

    return this.salary2;

    }

    public Double getSalary3(){

    return this.salary3;

    }

    public Double getShare(){

    return this.share;

    }

    public Double getHdmf(){

    return this.hdmf;

    }

    public Double getSss(){

    return this.sss;

    }

    public Double getTax(){

    return this.tax;

    }

    }

    /*--------------- FinalProject Class End ------------ */

    /*--------------- FinalProjectMain Class Begin ------------ */

    package teststack;

import java.util.Scanner;


public class FinalProjectMain {

public static void main(String[] args) 
{

    try{
    Scanner input = new Scanner(System.in);
    FinalProject output = new FinalProject();


    System.out.print("Good day! To you Sir/ma`am Thanks for helping me our program requires you to input your (basic salary) multiple times in order for us to compute your netpay");
    System.out.print("\nThank you Sir Have a Good day.\n\n\n");
    System.out.print("Enter Employee name: ");
    output.setName(input.nextLine());

    System.out.print("Enter your basic salary: ");
    output.setBasicsalary(input.nextDouble());

    System.out.print("Please Enter Your basic salary again to compute the philhealth contribution: ");
    output.setSalary(input.nextDouble());

    System.out.print("Please Enter your basic salary again to compute the hdmf: ");
    output.setSalary2(input.nextDouble());

    System.out.print("Please Enter the amount of HDMF you want to share: \n otherwise Enter 0 to deduct the default 100 HDMF share: \n");
    output.setHdmf(input.nextDouble());

    System.out.print("Please Enter your basic salary again to deduct the SSS in your salary: ");
    output.setSalary3(input.nextDouble());

    System.out.print("\n\nSSS deduction is: " + output.getSalary3());
    System.out.print("\n");

    System.out.print("(Please Enter the SSS duduction value above to compute the your tax): ");
    output.setTax(input.nextDouble());

    System.out.print("Please Enter again your basic salary to compute your netpay: ");
    output.setNetpay(input.nextDouble());

    System.out.print("Enter your basic salary again to determine your position: ");
    output.setCout(input.nextDouble());

     System.out.print("Employee name is: " + output.getName());
     System.out.print("\n");

     System.out.print("Your basic salary is: " + output.getBasicsalary());
     System.out.print("\n");

     System.out.print("Philhealth contribution is: " + output.getSalary());
     System.out.print("\n");

     System.out.print("Your HDMF share is: " + output.getHdmf());
     System.out.print("\n");
     System.out.print("SSS deduction is: " + output.getSalary3());
     System.out.print("\n");
     System.out.print("Your deduction Tax is: " + output.getTax());
     System.out.print("\n");
     System.out.print("Your netpay is: " + output.getNetpay());
    } catch (Exception e){
        System.out.println("ex : "+e);
    }


}

}

    /*--------------- FinalProjectMain Class End ------------ */