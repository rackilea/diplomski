File[] files=File.listRoots();
for(int i=0;i<files.length;i++)
{
  if(files[i].equals(f)){
  System.out.println(f+" is root");
  break;
  }
}