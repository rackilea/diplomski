public class Student{
    private String name;
    private int number;
    private int class;
public Student(String name, int number, int class){
  this.name = name;
  this.number = number;
  this.class = class;
}
public String getName(){
        return name;
    }
public int getNumber(){
        return number;
    }
public String getClass(){
        return class;
    }

public void setName(String name){
        this.name=name;
    }
public void setNumber(int number){
        this.number=number;
    }
public void setClass(int class){
        this.class=class;
    }
}


ArrayList<Student> studentList= new ArrayList<String>();    
FileReader fr = new FileReader(path);
    BufferedReader textReader = new BufferedReader(fr);
String line;
    while((line = textReader.readLine()) != null){
       if(line.equals("START")){
         Student st = new Student("",0,0);
          student.add(st);
        }else{
          StringTokenizer st = new StringTokenizer(line, "=");
          String title = st.nextElement();
          String data = st.nextElement();
          if(title.equals("Student.Number"))
             student.get(student.size-1).setNumber(data);
          if(title.equals("Student.Class"))
             student.get(student.size-1).setClass(data);
          if(title.equals("Student.Name"))
             student.get(student.size-1).setName(data);

        }
    }
    textReader.close();