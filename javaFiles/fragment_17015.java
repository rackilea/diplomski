public class Client{
    public int pin;
    public String name;
    public double amount;
    public Client(String name, double amount, int pin){
        this.name = name;
        this.amount = amount;
        this.pin = pin;
    }
    public String getName(){
        return name;
    }
    public int getPin(){
        return pin;
    }

    public void changePin(int newPin){
        this.pin = newPin;
    }
    public void withdraw (double amount)
    {
        this.amount -= amount;
    }

    public void deposit (double amount)
    {
        this.amount  += _amount;
    }
    @Override
    public String toString ()
    {
        return String.format("User: %s\nBalance: %s",this.name,this.amount);
    }
}