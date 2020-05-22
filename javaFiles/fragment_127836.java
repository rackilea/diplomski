try{
        FileReader fr = new FileReader("mikuname.txt");
        BufferedReader br = new BufferedReader(fr);

        String str;
        while ((str = br.readLine()) != null){
            System.out.println(str + "\n");
        }

        br.close();
}catch (Exception e){
//some exception information
}