while ((choice = readChoice()) != 'X') {
        switch (choice) {
        case '1': catalogue(); break;
        case '2': useAdmin(); break;
        }
    }

private void useAdmin() {
    char choice = admin(); // instead of assigning 5 to this option
        switch (choice) {
        case '1': listCustomer(); break;
        case '2': addCustomer(); break;
        case 'R': use();
    }
}