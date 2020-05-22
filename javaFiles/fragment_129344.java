you can create a global string like 

    String detectBtnStr = "";


    private void Click(View view1) {
        int id = view1.getId();

    switch(id){

    case: R.id.red_btn:
    detectBtnStr = "red";
    break;

    case: R.id.blue_btn:
    detectBtnStr = "blue";
    break;


    case: R.id.green_btn:
    detectBtnStr = "green";
    break;
    }

            }


and when come back then check with detectBtnStr like


 if (detectBtnStr.equals("red")) {
            // do your code}
        else if (detectBtnStr.equals("blue")) {
                // do your code
            }
            else if (detectBtnStr.equals("green")){
            // do your code
            }