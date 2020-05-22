List<Fund> maxFunds = new ArrayList<Fund>();
int max = 0;
for (Fund fund : funds) {
    if (fund.getFundValue() > max) {
        maxFunds.clear();
        max = fund.getFundValue();

    }
    if (fund.getFundValue() == max) {
        maxFunds.add(fund);

    }
}