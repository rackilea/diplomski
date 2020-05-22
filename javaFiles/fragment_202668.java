public OnlineStore() // Switch-case program
{
    do {
        display_menu();
        switch (mselect) {
            case 1:
                add_t();
                break;
            case 2:
                edit_t();
                break;
            default:  // If an error is encountered.
                JOptionPane.showMessageDialog(null, "Oh dear! Error!");
                break;
        }
    } while (mselect < 3);
}