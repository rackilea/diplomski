Scanner s = new Scanner(System.in);
System.out.println("Enter a vlaue for A : ");
int coA = s.nextInt();

if (coA==0){
    System.out.println("Error ! Enter a vlaue larger than 0 ");
    System.exit(-1);
};
System.out.println("Enter a vlaue for B : ");
int coB = s.nextInt();

System.out.println("Enter a vlaue for C : ");
int coC = s.nextInt();

double coTotal = (Math.pow(coB, 2))-4*coA*coC;

if(coTotal>0){
    System.out.println(" The System has two solutions ");
}
if (coTotal==0){
    System.out.println(" The System has one solutions ");
}
if(coTotal<0){
    System.out.println(" The System has ZERO solutions ");
}