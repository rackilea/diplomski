public class Medication { 
      String name; //name of you medication
      ArrayList<String> answers; //answers which you initialize by the order you want  

      public Medication (String name, ArrayList<String> answers) { 
            this.name = name;
            this.answers = answers;
      }

      public boolean isThisMedication(String name){
            if (this.name.equals(name))
               return true;
            return false;
      }

      public String getAnswer(int position) {
            return answers.get(position);
      }
}