public class ScrollBar{

    int c = 0; //default to red if the user gives a bad value

    public ScrollBar(int c){
        if(c >=0 && c <=2){ //check bounds
            this.color = c;
        }
    }

    public setColor(){
        if(this.color == 0){
            //do something with red
        }
        else if(this.color == 1){
            //do something with blue
        }
        else{
            //do something with green
        }
    }
}