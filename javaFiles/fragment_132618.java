/*modifed by raghu*/
if (hoursworked >= 40) {
    regPay = 40 * Level;
    overPay = (hoursworked -40)  * (Level * 1.5);
} else {
     regPay = hoursworked * Level;
}