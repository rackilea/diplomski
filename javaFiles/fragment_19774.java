SubMenu sm1 = m.addSubMenu(
                getResources().getString(R.string.firstRoundPicks));
        for (int x = 0; x < round1.size(); x++) {
            sm1.add(0, temp, temp, round1.get(x).toString());
                tempRooks.add(round1.get(x));
            temp++;
        }