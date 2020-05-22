package hello;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

class Test {
    public ArrayList arrayList;
    public List list;
    public HashSet hashSet;
    public Set set;
    public HashMap hashMap;
    public Map map;
    public Object object;
}

class Main {
    public static void main(String[] args) throws Exception {
        CtClass testClass = ClassPool.getDefault().get("hello.Test");

        for (CtField ctField : testClass.getFields()) {
            CtClass type = ctField.getType();

            Set<String> allSupper = getAllSuperclasses(type)
                    .stream()
                    .map(CtClass::getName)
                    .collect(Collectors.toSet());

            if (allSupper.contains(Map.class.getCanonicalName())){
                System.out.format("field %s is a Map\n", ctField.getName());
            }

            if (allSupper.contains(Collection.class.getCanonicalName())){
                System.out.format("field %s is a Collection\n", ctField.getName());
            }
        }
    }

    private static Set<CtClass> getAllSuperclasses(CtClass ctClass) throws NotFoundException {
        HashSet<CtClass> ctClasses = new HashSet<>();

        while (ctClass != null){
            ctClasses.add(ctClass);
            CtClass[] interfaces = ctClass.getInterfaces();
            Collections.addAll(ctClasses, interfaces);
            ctClass = ctClass.getSuperclass();
        }

        return ctClasses;
    }
}