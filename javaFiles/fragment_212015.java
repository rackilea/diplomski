int commas = 0;
for(int i = 0; i < helloWorld.length(); i++) {
    if(helloWorld.charAt(i) == ',') commas++;
}

System.out.println(helloWorld + " has " + commas + " commas!");