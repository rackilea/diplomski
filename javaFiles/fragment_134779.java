ObjectInputStream objIn = null;
try {
    FileInputStream fileIn = new FileInputStream("Serializado.txt");
    if (fileIn == null) {
        throw new IOException("Can't find file.");
    }
    objIn= new ObjectInputStream(fileIn);

    while (true) {
        obInp= (NewAlumno) objIn.readObject();
        System.out.print("Nombre   :" + obInp);
        System.out.print(", Sexo: " + obInp.getSexo());
        System.out.print(", Direccion: "+ obInp.getDireccion());    
        System.out.print(", Promedio: " + obInp.getpromedioPoo());
        System.out.print(", Telefono: " + obInp.getTelefono()+"\n");
    }
} catch (EOFException e) {
    // Ignore or do whatever you wanted to signal the end of file.
} catch (Exception ex) {
    ex.printStrackTrace();
} finally {
    try {
        if (objIn != null) {
            objIn.close();
        }
    } catch (IOException closeException) {
        closeException.printStackTrace();
    }
}