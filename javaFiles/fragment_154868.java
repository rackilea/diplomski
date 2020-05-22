Payment total =
            allPayments.stream()
                    .reduce(
                            new Payment("Total", 0, 0, 0),
                            (sum, each) -> new Payment(
                                    sum.getPaymentType(),
                                    sum.getPrice() + each.getPrice(),
                                    sum.getTax() + each.getTax(),
                                    sum.getTotal() + each.getTotal()));