// initialize an ArrayList:
List<Number> freq = new ArrayList<Number>();
BufferedReader br = new BufferedReader(new FileReader(new File("this.txt")));

String read;
String[] temp;

int num;

while((read = br.readLine())!=null)
{
    temp = read.split(",");
    for(int i = 0; i<=temp.length; i++)
    {
        String t = temp[i];
        num = Integer.parseInt(t);
        freq.add( num );
    }

}

System.out.println("done");