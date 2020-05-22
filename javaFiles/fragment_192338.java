import java.io.*;
import java.util.ArrayList;

public class BankAccount {

private  String name;
private  long accountNumber;
private  float balance;

public BankAccount(){//loads from file to arraylist
    BufferedReader in = null;
    ArrayList<BankAccount> customer_list=new ArrayList<BankAccount>();
    try {
        in = new BufferedReader(new FileReader("bankfile.txt"));
        String str;
        while ((str = in.readLine()) != null) {
            String[] temp_list=str.split(";");
            accountNumber=Long.parseLong(temp_list[1]);
            balance=Float.parseFloat(temp_list[2]);
            BankAccount customer = new BankAccount(temp_list[0],accountNumber,balance);
            customer_list.add(customer);
        }
        for(BankAccount c: customer_list) System.out.println(c.getName()+" "+c.get_Balance());
    }catch (FileNotFoundException e) {e.printStackTrace();
    } catch (IOException e) { e.printStackTrace();
    } finally {
        if (in != null) {
            try{ in.close();
            } catch(Exception e){e.printStackTrace();}
        }
    }
}
 public BankAccount(String name, Long accountNumber, float balance){
    this.name = name;
    this.balance = balance;
    this.accountNumber = accountNumber;
 }

public String getName() {
    return name;
}

public long getAccountNumber() {
    return accountNumber;
}

public float get_Balance() {
    return balance;
}
}