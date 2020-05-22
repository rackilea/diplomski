String s;
BufferedReader in = new BufferedReader(new FileReader(path));
s = in.readLine();
ArrayList<Student> slist = new ArrayList<>();
while (s != null){
    slist.add(new Student(s)); //creat a new student based on the string
    s = in.readLine();
}