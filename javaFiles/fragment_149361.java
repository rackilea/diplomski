package com.example.playground;

import java.util.HashMap;

public class TypeFactory {

    public interface IBase { }

    public interface IProvider <T extends IBase> {
        T getInstance();
    }

    private HashMap<Class<? extends IBase>, IProvider<? extends IBase>> registry =
            new HashMap<>();

    public <T extends IBase> void addProvider(Class<T> type, IProvider<T> provider) {
        registry.put(type, provider);
    }

    @SuppressWarnings("unchecked")
    public <T extends IBase> T create(Class<T> type) {
        return (T) registry.get(type).getInstance();
    }

    public static void main(String[] args) {
        TypeFactory factory = new TypeFactory();

        factory.addProvider(ISomeInterface.class, new IProvider<ISomeInterface>() {
            @Override
            public ISomeInterface getInstance() {
                return new ISomeInterface() {
                    @Override
                    public String toString() {
                        return "I'm a class that implements ISomeInterface";
                    }
                };
            }
        });

        ISomeInterface obj = factory.create(ISomeInterface.class);
        System.out.println(obj);
    }

}

interface ISomeInterface extends TypeFactory.IBase { }