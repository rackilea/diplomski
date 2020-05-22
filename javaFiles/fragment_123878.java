BufferedWriter output = new BufferedWriter(new FileWriter("D:\\Programe\\NetBeans\\Proiecte NetBeans\\[PA]Tema3Ex1\\Colectie.txt", true));
try {
    for (int y = 0; y < colectieTotala.size(); y++) {
        for (int k = 0; k < colectieTotala.get(y).size(); k++) {
            output.write(colectieTotala.get(y).get(k));
            output.newLine();
        }
    }
} finally {
    output.close();
}