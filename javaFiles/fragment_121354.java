String target1;
int testing = 0;  // move and initialize testing here

while ((target1 = br.readLine()) != null) //as long the condition is not null it will keep printing.
{
    //System.out.println(target1);

    testing += test.findTarget(target1, source1);
    //target1 = br.readLine();
}

System.out.println("answer is: "+testing);