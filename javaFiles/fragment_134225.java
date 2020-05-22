for(int i = 0; i < N; i++){
        start_index = (S/N)*i;
        end_index = start_index + (S/N);
        List<String> SUBblock= (TOTAL.subList(start_index, end_index)); 

        System.out.println("block "+i+": from "+start_index+" to "+end_index);
        System.out.println("block "+i+": "+SUBblock .toString());
    }