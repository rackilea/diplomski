try
{
    float num1,num2,num3,num4,sum;
    float div;
    DecimalFormat decft = new DecimalFormat("#.00");
    num1 = Float.parseFloat(txt_bin_balance.getText());
    num2 = Float.parseFloat(txt_issued_quantaty.getText());
    num3 = Float.parseFloat(txt_arrived_quantaty.getText());
    sum = (num1-num2)+num3;
    div = (float)sum; //sum is alredy float so you dont need this one anymore
    txt_final_bin_balance.setText(" " + String.valueOf(div));
}
catch(Exception e)
{
    JOptionPane.showMessageDialog(null,e);
}