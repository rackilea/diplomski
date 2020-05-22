public class CustomDate extends Date {
        ......
        @Override
        public String toString(){
            return new SimpleDateFormat("dd-MM-yyyy").format(this);
        }
}