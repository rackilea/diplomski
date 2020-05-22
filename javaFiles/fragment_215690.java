public class TaxTime {
  public static double calculateFamilyTaxSaving(double taxAmount, int familyMembers) {
    for (int i = 0; i <= familyMembers; i++) {
         taxAmount = taxAmount - 100;
    }

    return taxAmount;
  }
}

public class TaxTimeTest {
  @BeforeEach
  void setUp() throws Exception {
    // only use this if you actually do some initialization before each test.
  }

  @Test
  void whatEverTestMethodNameYouWantToUse() {
    double actualDoubleResult;
    BigDecimal actualBigDecimalResult;
    BigDecimal expectedBigDecimal = new BigDecimal(300.0);
    TaxTime taxtime = new TaxTime();
    double taxAmount = 600;
    int familyMembers = 3;

    actualDoubleResult = taxtime.calculateFamilyTaxSaving(taxAmount,familyMembers);

    actualBigDecimalResult = new BigDecimal(actualDoubleResult);

    assertTrue(0 == expectedBigDecimal.compareTo(actualBigDecimalResult));
  }
}