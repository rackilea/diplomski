Scanner s = new Scanner (System.in);
String line;
while(!(line = s.nextLine()).isEmpty()){
    a.add(i, line);
    i++;
}

System.out.println(a.size());