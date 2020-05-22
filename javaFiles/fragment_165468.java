BufferedWriter outFile = new BufferedWriter(new FileWriter("silverbullet_rro_output.csv"));
StringBuilder builder = new StringBuilder();

for (int i = 0; i < labeled.size(); i++)      
{
    double[] clsLabel = clf.distributionForInstance(newTest.instance(i));
    for(int j=0;j<2;j++){
       builder.append(clsLabel[j]+""); 
       if(j < clsLabel.length - 1)
           builder.append(",");
    }
    builder.append("\n");
}
outFile.write(builder.toString());//save the string representation
System.out.println("Output file written.");
System.out.println("Completed successfully!");
outFile.close();