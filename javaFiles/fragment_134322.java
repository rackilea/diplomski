InputStream anterior = null;
ByteArrayOutputStream saida = new ByteArrayOutputStream();
for (File file : lista) {
    saida.reset();
    List<String> marcadores = marcadores(file.getName());           
    InputStream novo = new FileInputStream(file);           
    merge.concatena(anterior, novo, saida, marcadores);                     
    anterior = new ByteArrayInputStream(saida.toByteArray());
}