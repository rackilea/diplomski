interface Executor {}

interface UsableExecutor extends Executor {}

class Executor1 implements UsableExecutor{...}
class Executor2 implements UsableExecutor{...}
class Executor3 implements UsableExecutor{...}
class Executor4 implements Executor {}  // note, doesn't implement UsableExecutor

@Component
class SomeClassWithUsableExecutors {

   private final List<UsableExecutor> usableExecutors;

   // an autowired constructor - only 3 elements will be in the list 
   public SomeClassWithUsableExecutors(List<UsableExecutor> usableExecutors) {
      this.usableExecutors = usableExecutors;
   } 
}