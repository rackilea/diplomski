//double check =0.615 * 255 + -0.515 * 255 + -0.100 * 255;
   BigDecimal check =
             (BigDecimal.valueOf(0.615).multiply(BigDecimal.valueOf(255)))
            .add(BigDecimal.valueOf( -0.515).multiply(BigDecimal.valueOf( 255)))
            .add(BigDecimal.valueOf( -0.100).multiply(BigDecimal.valueOf( 255)));

  System.out.println(check);