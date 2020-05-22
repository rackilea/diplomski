public interface BasedOnSomeType<U extends BasedList<SomeType>>
         extends BasedOnOther<SomeType, U>
{
}

public class X implements BasedOnSomeType<MemoryModel> { ... }