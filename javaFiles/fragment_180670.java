public static void start(){
    for(int a = 0; a <= 22; a++){
        for(int b = 0; b <= 37; b++){
            printToCell(String.valueOf(b), String.valueOf(a), "H");
        }
    }
}


public static void clearContentPane(){
    engine_design.Engine.contentPane.removeAll();
    engine_design.Engine.contentPane.setLayout(new MigLayout("", "", ""));
}


public static void printToCell(String column, String row, String letter){
    JLabel lblH = new JLabel(letter);
    lblH.setFont(new Font(lblH.getName(), Font.BOLD, 15));
    engine_design.Engine.contentPane.add(lblH, "cell " + column + " " + row);

}