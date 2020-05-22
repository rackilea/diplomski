//check to see if car park is full
void checkFull()
{
    for(int i = 0; i < parkingSpace.length; i++)
    {

        if (parkingSpace[i].getIcon() == null)
        {
          return;
        }

    }
    JOptionPane.showMessageDialog(null, "Sorry the Car Park is full!");

}