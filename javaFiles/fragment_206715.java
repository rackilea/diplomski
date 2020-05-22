class BubbleSort {
    BubbleSort(ArrayList<Integer> Bubblesort){
        boolean controle;

        for (int i = 0; i < Bubblesort.size()-1; i++){
            controle = true;
            for (int j =0; j < (Bubblesort.size()-i-1); j++){
                if (Bubblesort.get(j).compareTo(Bubblesort.get(j+1))>0){
                    Integer a = Bubblesort.get(j);
                    Bubblesort.set(j, Bubblesort.get(j+1));
                    Bubblesort.set(j+1, a);
                    controle = false;
                }
            }
            if (controle){
                break;
            }
        }
        for(int i = 0; i < Bubblesort.size();i++){
            System.out.println(Bubblesort.get(i));
        }
    }
}