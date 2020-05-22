public class PlayerPane extends JPanel{
    ...

    public void paintComponent(Graphics g){
        ...

        // modifying index
        if(index == images.length-1){
            index = 0;
        } else {
            index++;
        }
    }
}