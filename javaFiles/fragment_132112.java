public class MainHolder {

public Integer main[] = new Integer[8];

public MainHolder(){
  MakeMain();
}
public void MainMaker(int k,int p){

    main[p] = k;

}
public void MakeMain(){

    MainMaker(0,0); // Money

    MainMaker(0,1); // Money Clicks

    MainMaker(0,2); // Boxes

    MainMaker(0,3); // Boxes Clicks

    MainMaker(1,4); // Boxes Level

    MainMaker(1,5); // Player Level

    MainMaker(1,6); // Garage Level

    MainMaker(0,7); // Garage Slots

}