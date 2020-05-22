package so.answers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TemplateGenerics {

    private final List<Conditional> conditionals = new ArrayList<>();

    public List<Conditional> getConditionals(){
        return conditionals;
    }

    public String toString(){
        return getConditionals().toString();
    }

    public static TemplateGenerics of(Class<?> clazz) {
        return TemplateGenerics.of(clazz, new HashMap<>());
    }

    private static TemplateGenerics of(Class<?> clazz, Map<Class<?>, TemplateGenerics> existingGenericsForClasses) {
        if(existingGenericsForClasses.containsKey(clazz)){
            return existingGenericsForClasses.get(clazz);
        }
        final TemplateGenerics generics = new TemplateGenerics();
        existingGenericsForClasses.put(clazz, generics);

        Stream.of(clazz.getTypeParameters()).forEach(typeVariable -> {
            java.lang.reflect.Type b = typeVariable.getBounds()[0];
            try {
                Class<?> c = Primitives.resolveClass(b.getTypeName().split("<", 2)[0]); //Is there a better way to do this?
                TemplateGenerics sub = TemplateGenerics.of(c, existingGenericsForClasses); //Recursivley get the generics - it fails here
                generics.getConditionals().add(new Conditional(new Type.Hierarchical(sub, c.getName()), Conditional.Condition.EXTENDS, typeVariable.getName())); //Conditional is another wrapper class that handles bounds of the generic, 
                                                                                                                                                                 //Type.Hierachical is yet another wrapper class that wraps types that appear in class headers
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e); //For testing purposes
            }
        });
        return generics;
    }

    public static class Conditional{
        public static enum Condition{
            EXTENDS,
            SUPER
        }

        private final Type.Hierarchical hierarchical;
        private final Condition condition;
        private final String typeName;

        public Conditional(Type.Hierarchical hierarchical, Condition condition, String typeName){
            this.hierarchical = hierarchical;
            this.condition = condition;
            this.typeName = typeName;
        }

        public String toString(){
            return "Conditional$typeName="+typeName+" "
                    +"Conditional$condition="+condition+" "
                    +"Conditional$hierarchical={"+hierarchical+"} ";                    
        }
    }

    public static class Primitives{
        public static Class<?> resolveClass(String name) throws ClassNotFoundException{
            String trimmedName = name.replaceFirst(TemplateGenerics.class.getCanonicalName()+".", "");

            //not sure why this nonsense with the trimmed name
            //is necessary, but you seem to already have a better
            //version of this method anyway
            if(trimmedName.contains(TemplateGenerics.class.getCanonicalName())){
                name = trimmedName;
            }
            return Primitives.class.getClassLoader().loadClass(name);
        }
    }

    public static class Type{
        public static class Hierarchical{
            private TemplateGenerics generics;
            private String name;

            public Hierarchical(TemplateGenerics generics, String name){
                this.generics = generics;
                this.name = name;
            }


            private boolean printing;

            public String toString(){
                try{
                    if(!printing){
                        printing = true;
                        return "Hierarchical$name="+name+ " Hierarchical$generics=("+generics+")";
                    } else {
                        return "Hierarchical$name="+name;
                    }
                } finally {
                    printing = false;
                }
            }
        }
    }

    public static class B{

    }

    public static class C<T extends B>{

    }

    public static class A<T extends A<T>>{

    }

    public static class X<T extends Y>{

    }

    public static class Y<T extends X>{

    }

    public static void main(String[] args){
        System.out.println("For A:"+TemplateGenerics.of(A.class));
        System.out.println("For C:"+TemplateGenerics.of(C.class));
        System.out.println("For X:"+TemplateGenerics.of(X.class));
    }
}