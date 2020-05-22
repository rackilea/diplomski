public void runProcedure(){
try {
    int step  = 1;
    while(step != 4) {
        switch(step){
            case 1:
            //run "verify operator"

            step = 2;
            break;
            case 2: 
            //run "Ask operator for item number"

            if (itemnumber == right) {
                // program should just continue
                step = 3;
            }
            else {
                // I should run case 1 or 2 again.
                step  = 1;
            }
            break;
            case 3: 
            //run "Ask operator to verify item name"
            step = 4;
            break;
            default:
            //default
        }
    }
}catch(Exception e) {
}
}