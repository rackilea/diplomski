//Returns Desktop
@GetMapping("/getDesktop")
public ArrayList<String> getDesktop() throws Exception {
    ArrayList<String> itemNames = new ArrayList<>();
    int kill = 0; 

    while(kdxF.getUser() == null) {    // FIXME
        if(kill == 500) {
            break;
        }else {
            Thread.sleep(5);
            kill++;
        }
    }

    itemNames = kdxF.showDesktop();

    return itemNames;
}