public int[] ConvertToArray(File xd) throws IOException {     

 String sCadena;

    ArrayList<Integer> array = new ArrayList();

    FileReader fr = new FileReader(xd); 
    BufferedReader bf = new BufferedReader(fr);
    int lNumeroLineas = 0;
    while ((sCadena = bf.readLine())!=null) {
        lNumeroLineas++;
        array.add(Integer.parseInt(sCadena.trim())); //always recomended to trim(); to remove trailing whitespaces.
    }

    for (int j = 0; j < array.size(); j++) {
        System.out.println(array.get(j));
    }
    return covertIntegers(array);
}