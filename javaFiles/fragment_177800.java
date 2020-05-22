File file = new File("e://filename"+i+".txt");   
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);

while(iter.hasNext())
{           
        DataPoint dpTemp = (DataPoint)iter.next();
        System.out.println(dpTemp.getObjName()+"["+dpTemp.getX()+","+dpTemp.getY()+"]");

        bw.write("\n"+dpTemp.getObjName()+" ["+dpTemp.getX()+","+dpTemp.getY()+"]");                        
}
//bw.close();
bw.flush();
System.out.println("Done");