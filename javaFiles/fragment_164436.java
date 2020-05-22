public class Member<T> {

public final Class<T> type;

private T id;
private T complexityLevel;

//constructor   
public Member(T id, T complexityLevel, Class<T> type) {
   id = id;
   this.complexityLevel = complexityLevel;
   this.type = type;
}