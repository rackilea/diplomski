File outFile = new File ("output.txt");
FileWriter fWriter = null;
try { fWriter = new FileWriter (outFile); }
catch (IOException e) { e.printStackTrace(); }
PrintWriter pWriter = new PrintWriter (fWriter);
for (String[] car : arr)
{
    if (restrictBy(car, "Ford" , "", "Truck"))
    {
        System.out.println(car[0] + " " + car[1] + " " + car[2] + " " + car[3]);
        pWriter.println(car[0] + " " + car[1] + " " + car[2] + " " + car[3]);
    }
}
pWriter.close();