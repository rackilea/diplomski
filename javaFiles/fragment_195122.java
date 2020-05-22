javap -s AbstractIntegerConverter.class

Compiled from "AbstractIntegerConverter.java"
public abstract class de.scrum_master.app.AbstractIntegerConverter<T> implements de.scrum_master.app.Converter<T, java.lang.Integer> {
  public de.scrum_master.app.AbstractIntegerConverter();
    descriptor: ()V

  public java.lang.Integer convert(T);
    descriptor: (Ljava/lang/Object;)Ljava/lang/Integer;

  public abstract java.lang.Integer defaultValue();
    descriptor: ()Ljava/lang/Integer;

  public java.lang.Object convert(java.lang.Object);
    descriptor: (Ljava/lang/Object;)Ljava/lang/Object;
}