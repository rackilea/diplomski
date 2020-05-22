public class SingletonGame{

    private static final SingletonGame SINGLETON = new SingletonGame();

    public static SingletonGame getInstance(){
        return SINGLETON;
    }

    private int sum;
    //or
    private List<Integer> operations = new ArrayList<>();

    private SingletonGame(){}

    public int getSum(){
        return sum;
    }

    //or
    public List<Integer> getOperations(){
        return operations;
    }

    public void addSum(int num){
        this.sum += num;
    }

    //or
    public void addOp(int num){
        this.operations.add(num);
    }

    publi void getResult(){
        //inside this method you have your logic
        //for calculate result
    }

}

//Inside your action

private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==finish)
                JOptionPane.showMessageDialog(null, "You made " + wrongs + "correct tries.");
            else{
                Square sqr = (Square) e.getSource();
                int num = sqr.getNum();
                // you must do control when is case for call SingletonGame.getInstance().getResult();
                SingletonGame.getInstance().sum(num);

            }
        }
    }