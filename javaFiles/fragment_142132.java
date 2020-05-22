@Override
public void actionPerformed(ActionEvent event) {
    ...

    EventQueue.invokeLater(new Runnable() { // Added
        ... rest of the code
    }); // Added
}