public String simon() {
    while(true){
        generateColor();
        for(int i = 0; i < colors.size(); i++){
            JOptionPane.showMessageDialog(null, "Color #"+i+" is: "+colors.get(i));
        }
        for(int i = 0; i < colors.size(); i++){
            String input = JOptionPane.showInputDialog("Type in #"+i+" color: ");
            if(input == null){
                System.out.println("User typed in wrong input");
                return "Program ended unsuspectively";
            }
            if(input.equalsIgnoreCase(colors.get(i))){
                System.out.println("You were correct!");
            }
            else{
                System.out.println("you wasnt correct");
                return "You ended with a score of: "+score;
            }
        }
        score++;
    }
}

private void generateColor(){
    int c = (int)(Math.random() * 4);
    colors.add(obj[c]);
}