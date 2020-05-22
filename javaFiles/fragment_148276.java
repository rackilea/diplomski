Table.java
    package models;
    // relevant imports
    @entity("table")
    public class Table{
        @OneToOne(mappedBy = "table")
        private View view;
        public string getVariable();
        public string setVaraible();
    }

    View.java
    package models;
    // relevant imports
    @entity("view")
    public class View{
       @OneToOne
       @JoinColumn(name = "table_id")
       private Table table;

       public string getVariable();
       public string getVariable2();
       public string getVariable3();//etc, No setters.

       //alternatively use insertable//updateable=false on all column annotation
       @Column(name="variable_4", insertable =  false, updateable=false)
       public string getVariable4();
    }