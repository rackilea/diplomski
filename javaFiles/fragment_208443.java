public class AndOperation implements Operand, Argument {

    private Argument argument1;
    private Argument argument2;
    private String output;

    public AndOperation( Argument arg1, Argument arg2 ) {
       this( arg1, arg2, null ); // this is for chaining where no output exists.
    }

    public AndOperation( Argument arg1, Argument arg2, String output ) {
       this.argument1 = arg1;
       this.argument2 = arg2;
       this.output = output;
    }

    public boolean evaluate() {
       return argument1.evaluate() && argument2.evaluate();
    }

    public String getOutputRegister() {
       return output;
    }
}

public interface Argument {
    public boolean evaluate();
}

public class Register implements Argument {
    private String name;
    private boolean value;

    public boolean evaluate() {
       return value;
    }

    public void setValue( boolean value ) {
       this.value = value;
    }
}


public class Program implements Iterable<Operand> {

   public Map<Register> registers;
   public List<Operand> operands;

   public void parse( InputStream stream ) {
      // this will take in a stream, parse it, and create the 
      // program.  Create the registers, and operands used 
      // to evaluate the program
   }

   public void evaluate() {
      for( Operand op : operands ) {
         evaluate( op );
      }
   }

   public void evaluate( Operand operand ) {
         boolean output = op.evaluate();
         String name = op.getOutputRegister();
         Register register = registers.get( name );
         register.setValue( output );
   }          

   public Iterator<Operand> iterator() {
      return new Debugger( this );
   }
}

public class Debugger implements Iterator<Operand> {
   private Program program;
   private int line = 0;

   public boolean hasNext() {
      return line < program.size();
   }

   public Operand next() {
      Operand operand = program.getOperands().get( line );
      program.evaluate( operand );
      line++;
      return operand;
   }
}