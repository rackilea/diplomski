public interface ReadOnlySlave {
    public void printname();
}

public class Slave : ReadOnlySlave {
   public void printname() { ... }

   public void setName() { .... }
}

public ReadOnlySlave getConstSlave() {
   return slave;
}