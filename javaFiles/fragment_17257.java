nazwy = names
oceny = numbers
sOceny = sNumbers
cbLista = cb
tNazwa = tNames
tOceny = tNumbers

//----
else if(s == bComboDelete)
    {
        Object o = cbLista.getSelectedItem();

            int z = nazwy.indexOf(o);
            if(z>-1)
            {
            sOceny.remove(z);
            nazwy.remove(z);
            cbLista.removeItemAt(z);
            System.out.println("Oceny w bloku delete(if)"+oceny.toString());
            }
            System.out.println("Oceny w bloku delete(poza if)"+oceny.toString());
    }

    else if(s == cbLista)
    {
        Object o = cbLista.getSelectedItem();

        int z = nazwy.indexOf(o);
        if(z>-1)
        {
        tNazwa.setText(nazwy.get(z));
        oceny.clear();
        oceny=arrayStringToIntegerArrayList(sOceny.get(z));
        tOceny.setText(oceny.toString().substring(1, oceny.toString().length()-1));
        System.out.println("Oceny w bloku CB"+oceny.toString());
        }
        else
        {
            tNazwa.setText("");
            tOceny.setText("");
            oceny.clear();
        }


    }