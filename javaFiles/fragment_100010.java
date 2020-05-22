for (int i = 0; i <= 10; i++) {                                             //10 is a random testing number
    //In the real version s changes here
    items = new ArrayList<String>(Arrays.asList(s.split("\\s*,\\s*"))); //split strings by comma accounting for the possibility of a space

    // create this inside so you have a new one for each inner list
    ArrayList<Float> temp = new ArrayList<>(); 
    for (String b : items) {                                                //parse each number in the form of a string into a float, round it, and add it to temp
        temp.add((float)((long)Math.round(Float.valueOf(b)*10000))/10000);  
    } //End parsing loop

    output.add(temp);  

    // don't clear
    //temp.clear();                                                           //clear temp
} //End primary loop