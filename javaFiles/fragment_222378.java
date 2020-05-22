public static void main(String[] args) {
    MyConsole console = new MyConsole();

    console.println("Hello! (Type \"0\" to exit)");

    int age = 1;

    do{
        console.println("How old are you ?");
        String read = console.read();
        try {
            age = Integer.valueOf(read);

            if ( age >= 18){
                console.println("Wow! " + age + " ? You are an adult already!");
            }else if ( age > 0 ){
                console.println("Oh! " + age + " ? You are such a young boy!");
            }else if (age == 0){
                console.println("Bye bye!");
            }else{
                console.println("You can't be " + age + " years old!");
            }
        }catch (Exception e) {
            console.println("Did you write any number there ?");
        }
    } while ( age != 0 );

    console.closeConsole();
}