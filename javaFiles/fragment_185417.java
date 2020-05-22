public class Foo { 
  public static void main(String[] args) { 
    Bar bar = new Bar(); 
  }
}
class Bar { 
   int bar_var; 
   Snafu fu = new Snafu(); 

   public Bar() {  } 
   public int getBarVar() { return bar_var; } 
} 
class Snafu { 
   int var; 
   public Snafu() { } 
}

....