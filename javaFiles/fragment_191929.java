class Subject {
   private int id;
   private String name;

   public Subject(int id, String name) {
       this.id = id;
       this.name = name;
   }

   public int getId() { return id; }
   public String getName() { return name; }

   @Override
   public String toString() {
       return name;
   }
}

DefaultListModel model = new DefaultListModel();
model.addElement(new Subject(1, "Math"));
Subject subject = (Subject)model.getElementAt(0);
System.out.println(subject);
// result -> Math