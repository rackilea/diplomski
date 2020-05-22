BufferedReader[] readers = new BufferedReader[5]; 
readers[0] = new BufferedReader(new FileReader("...));
...
readers[4] = new BufferedReader(new FileReader("...));


boolean noMoreLine = false;
while (!noMoreLine)       

   for (BufferedReader reader : readers){
        String line = reader.readLine();
        if (line == null){
           noMoreLine = true;
           System.out.println("no more line");
           break;
        }
        System.out.println("Line " + i + " = line);
       }
    }

}