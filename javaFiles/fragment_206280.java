public static void backtrackWineAll(List<Integer> priceList, List<Integer> choosen) {

    if(priceList.isEmpty()) {
        System.out.println(choosen);
    } else {
        Integer first = priceList.remove(0);
        choosen.add(first);//choose the first bottle.

        backtrackWineAll(priceList, choosen);

        choosen.remove(choosen.size()-1);
        priceList.add(0, first);

        if (priceList.size () > 1) { // the added condition
            int lastPos = priceList.size()-1;
            Integer last = priceList.remove(lastPos);
            choosen.add(last); //choose the last bottle.

            backtrackWineAll(priceList, choosen);

            choosen.remove(choosen.size()-1);
            priceList.add(last);
        }
    }
}