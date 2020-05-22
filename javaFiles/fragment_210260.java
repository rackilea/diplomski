for(int i = 0; i < moneys.length; i++) {
        m[i] = new Money(moneys[i].getDollars(), moneys[i].getCents());

        m[i].newDollars = m[i].getDollars() * amt;
        m[i].newCents = m[i].getCents() * amt;
        m[i].normalize();
        m[i].moneyDollars = m[i].newDollars;
        m[i].moneyCents = m[i].newCents;
    }