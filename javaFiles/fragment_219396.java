public void setTime() {
    Scanner reader= new Scanner(System.in); 
    int h=reader.nextInt();
    int m=reader.nextInt();
    int s=reader.nextInt();
    hour= ((h>=0 && h<24) ? h: 0);
    minute= ((m>=0 && m<60) ? m: 0);
    second= ((s>=0 && s<60) ? s : 0);   
}