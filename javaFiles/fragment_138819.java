public TeamLeader(String name, String number, String hd, int shift, 
        double rate, double monthlyBonus, double RTH, double CTH)
{
    super(name, number, hd, shift, rate);
    this.monthlyBonus = monthlyBonus;
    this.RTH = RTH;
    this.CTH = CTH;
}