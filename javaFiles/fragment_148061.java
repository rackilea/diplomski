private boolean validar() {
    int i;
    boolean f = false;
    String pass = new String(f_pass.getPassword());
    if (f_usuario.getText().equals("") || pass.equals(""))
        JOptionPane.showMessageDialog(this, "Por favor complete todos los campos");

    for (i = 0; i < 5; i++) {
        if (f_usuario.getText().equals(usuarios[i].getUsuario()) && pass.equals(usuarios[i].getPass()))
            f = true;
    }

    if (f)
        JOptionPane.showMessageDialog(this, "Logueo exitoso");
    else
        JOptionPane.showMessageDialog(this, "La combinación de usuario y contraseña no existe");
    return (true); // always return true
}