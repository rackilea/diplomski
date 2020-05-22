final int iCopy = i;
final int jCopy = j;
@Override
public void mouseClicked(MouseEvent click) {
    if ((iCopy+jCopy)%2==0) {
        squares[iCopy][jCopy].setBackground(Color.white);
    } else {
        squares[iCopy][jCopy].setBackground(Color.black);
    }
}