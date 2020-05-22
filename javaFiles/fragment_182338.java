if(nimi.length()>0){
        System.out.println("Anna ko. valtion pääkaupunki: ");
        pääkaupunki = lukija.nextLine();
        System.out.println("Anna ko. valtion asukasluku: ");
        asukasluku = lukija.nextInt();
        Valtio valtio = new Valtio(nimi, pääkaupunki, asukasluku);
        valtiot.add(valtio);
        lukija.nextLine();
    }