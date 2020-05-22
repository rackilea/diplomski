List<USCrimeClass> crimeClasses = new ArrayList<>();
read.nextLine();
while(read.hasNextLine())
{
    crimeClasses.add(new USCrimeClass(read.nextLine()));
}

read.close();

System.out.println(crimeClasses.get(0));