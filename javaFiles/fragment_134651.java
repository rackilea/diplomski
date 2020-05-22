int total = 0;
for (Bet bet : copy) {

    if (random < total + getChance(bet)) {
        return bet;
    }
    total += getChance(bet);
}