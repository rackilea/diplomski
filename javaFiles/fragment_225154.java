import java.math.BigDecimal;

BigDecimal premium = BigDecimal.valueOf("1586.6");
BigDecimal netToCompany = BigDecimal.valueOf("708.75");
BigDecimal commission = premium.subtract(netToCompany);
System.out.println(commission + " = " + premium + " - " + netToCompany);