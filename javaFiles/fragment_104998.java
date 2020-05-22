BigDecimal totalCharge = BigDecimal.ZERO;
double totaldataUsage = 0;
for(CallDetailFull item: callDetails){
    totalCharge = totalCharge.add(item.getCharge());
    totaldataUsage += item.getDataUsage();
}