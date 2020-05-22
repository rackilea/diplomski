public class InstanceMap {
    public static ObjectValue KEY0(){
        return new ObjectValue();
    }

    public static ObjectValue1 KEY1(final String name){
        return new ObjectValue1(name);
    }

    public static ObjectValue2 KEY4(final String name, final int age){
        return new ObjectValue2(name, age);
    }
}

// method call
InstanceMap.KEY0();
InstanceMap.KEY1(name);