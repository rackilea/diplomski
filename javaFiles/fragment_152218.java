public class ObjectArray {

    Track[] track;

    public static void main(String[] args){
        ObjectArray tester = new ObjectArray();
        tester.setIt();
        tester.getIt();
    }

    public void setIt(){
        track = new Track[42];
        for(int i=0; i<42; i++){
            track[i]= new Track(i);
            track[i].calcProduct(i, i+1);
        }
    }

    public void getIt(){
        for(int i=0; i<track.length; i++){
            System.out.println("Track "+track[i].getSerial()+" has product: "+track[i].getProduct());
        }
    }

    class Track{
        private int serial;
        private int product;

        Track(int i){
            serial = i;
        }

        public void calcProduct(int a, int b){
            product = a*b;
        }

        public int getSerial() {
            return serial;
        }

        public int getProduct() {
            return product;
        }
    }
}