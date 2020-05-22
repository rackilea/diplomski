Pattern p1 = Pattern.compile(".* educated at (.*)");//note the parenthesis
int count = 0;

while((line = br.readLine()) != null){
    String datavalue[] = line.split("\t");
    String text = datavalue[2];
    Matcher m = p1.matcher(text);
    if(m.matches()){
        count++;
        System.out.println(m.group(1));

    }
}