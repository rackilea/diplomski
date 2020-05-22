while((line = br.readLine()) != null){

    if (line.equals("#END#")) {
       break;
    } else {
       System.out.println(line);
    }
}