@Override
public Object getValueAt(int rowIndex, int columnIndex) {

    Person person = dataList.get(rowIndex);

    switch (columnIndex) {
        case 0:
            return person.imie;
        case 1:
            return person.nazwisko;
        case 2:
            return data(cal, person);
        case 3:
            return person.kolor.getRGB();
        case 4:
            return person.wzrostCm;
        case 5:
            return person.wagaKg;
        case 6:
            //Return the entire Person object so that the column class matches to our custom cell renderer
            return person;

    }

    return null;
}