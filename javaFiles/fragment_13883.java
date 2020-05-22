import javax.annotation.PostConstruct;
...
    @PostConstruct
    private void init(){
        ...
        if(this.getStudentList() == null){
           loadStudents();              
        }   
    }