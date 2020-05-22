/**
 * Build an action listener to change the color of the label.
 *
 * @param label The label to change.
 * @param color The color to use.
 * @returns The action listener which changes the color.
 */
public static ActionListener BuildActionListener(JLabel label, Color color) {
    return new ActionListener(){
        public void actionPerformed(ActionEvent event){
            label.setForeground(color);
        }
    };
}