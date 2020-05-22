package bla;

public class Something {
    public static int count = 0;
    public Something get() {
        if(count == 2) {
            return null;
        }
        ++count;
        return new Something();
    }

    public static void main(String[] args){
        Something something = new Something();
        Something test = something.get()
                                .get()
                                    .get()
                                        .get() // Should throw NPE
                                            .get()
                                                .get();
    }
}