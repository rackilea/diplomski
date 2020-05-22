class Operation
{
    public delegate void ResultHandler(object Operation, String result);
    public event ResultHandler Result;

    public void Search(String word) {

        Thread.Sleep(3000);
        if (Result != null)            
            Result(this, "Result for " + word);            
    }
}


public partial class Form1 : Form
{
    public Form1()
    {
        InitializeComponent();
    }

    private void Form1_Load(object sender, EventArgs e)
    {
        Operation op = new Operation();
        op.Result += op_Result;
        op.Search("Facebook");

    }

    void op_Result(object Operation, string result)
    {
        MessageBox.Show(result);
    }        
}