public class EFrog {
        public static void main(String[] args) {
            Frog f = new Frog();
            Amphibian g = (Amphibian)f;//this is an upcast
            g.go(); //okay since Amphibian can go
            g.come();//not okay since Amphibian can't come                
        }
    }