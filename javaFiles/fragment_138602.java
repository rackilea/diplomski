package mypackage;

import java.util.ArrayList;
import java.util.List;

public class Job {
      public static class GlobalVars
      {
        private List<Variable> variables;
        public List<Variable> getVariable()
        {
            if (this.variables == null) {
                this.variables = new ArrayList<Variable>();
            }
            return this.variables;
        }

        public static class Variable
        {
          String name;
          String value;
          public String getName() { return name; }
          public void setName( String name ) { this.name = name; }
          public String getValue() { return value; }
          public void setValue( String value) { this.value= value; }
        }
      }  
}