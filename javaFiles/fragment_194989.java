public static void stringToArray (){                                  
        Scanner in = new Scanner(System.in);
        System.out.print("Input String: ");             
        String input = in.nextLine();
        Integer[] lista = new Integer[input.length()];
        for(int i=0;i<input.length();i++) {
            lista[i] = input.codePointAt(i);  
            System.out.print(lista[i] + " ");
        }        
        System.out.print("\nArray descending order: ");
        Arrays.sort(lista, Collections.reverseOrder());
        for(int i=0;i<input.length();i++) 
            System.out.print(lista[i] + " ");                                   
        if (lista.length>0) {  
            int min=lista[0];
            int max=lista[0];
            int sum=0;
            int avg;
            for(int i=0;i<lista.length;i++){
                if (lista[i]> max) max=lista[i];
                if (lista[i]< min) min=lista[i];
                sum += lista[i];                
            }
            avg=sum/lista.length;                
            System.out.println("\nThe maximun value is: "+max);
            System.out.println("The minimun value is: "+min);
            System.out.println("The average value is: "+avg);                            
        }
}