Component[] components = firstJPanel.getComponents();
for (int i = 0; i < components.length; i++) {
    System.out.println("Componenet name - " + components[i].getName());
    if (components[i] instanceof JPanel
            && components[i].equals(secondJPanel)) {

        Component s[] = ((JPanel) components[i]).getComponents();
        for (int j = 0; j < s.length; j++) {
            System.out.println("Sub Componenet name - " + s[j].getName());
        }
    }
}