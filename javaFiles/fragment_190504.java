private void playerHealth() {
    if (player.health <= 0) {
        JOptionPane.showMessageDialog(null, "you lose");
        System.exit(0);
    }
}