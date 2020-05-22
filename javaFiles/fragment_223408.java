public class Mango {
    static enum Upper {A,B,C}
    static enum Lower {a,b,c}


    static <SRC extends Enum<SRC>,DST extends Enum<DST>> DST convert(SRC a, Class<DST> classDst ){
        return  Enum.valueOf(   classDst,a.name().toUpperCase());
    }

    public static void main(String[] args) {
        System.out.print(convert(Lower.a,Upper.class));
    }

}