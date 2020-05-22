while(true){
    System.out.println("Ange tal: (0-avsluta)");
    int temp = scan.nextInt();
    if(i == a1.length || temp == 0)
    {
        break;       
    }
    else
    {
        a1[i] = temp;
        i++;
    }

}