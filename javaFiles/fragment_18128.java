class SomeVariables {
    String s;
    int dontneed;
}

class MainClass {
    public static void main(String[]args){
        SomeVariables vars = new SomeVariables();

        vars.s = "why this doesnt work?. IDE says Uknown class 'vars.s'";
        System.out.println(vars.s);
    }
}