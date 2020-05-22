public void getDataFromB(ArrayList<String> data)
{
    this.dataFromB = data;
}

public void startFormB()
{
    this.setVisible(false);
    B formB = new B(this);
}