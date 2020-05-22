while((string = bufferedReader.readLine()) != null) {
    for (String url: string.split("\t")) {
        if(url.contains(".com.jp")) {
            bufferedWriter.write(url);
            bufferedWriter.write("\t");
            System.out.println(url);
        }
    }
    bufferedWriter.write("\n");
}