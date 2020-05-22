List<String> lines = new ArrayList<>();

read.nextLine();
while(read.hasNextLine())
{
    lines.add(read.nextLine());
}

USCrimeClass[] CrimeYear = new USCrimeClass[lines.size()];

for(int i=0;i<lines.size();i++)
{
    CrimeYear[i]=new USCrimeClass(lines.get(i));
}
read.close();