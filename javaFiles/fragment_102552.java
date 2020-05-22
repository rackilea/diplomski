private static final BinaryOperator<FactureMensuel> applatirListeFactureMensuelle = new BinaryOperator<FactureMensuel>() {
        @Override
        public FactureMensuel apply(FactureMensuel factureMensuel, FactureMensuel factureMensuel2) {
            factureMensuel2.forEach((k, v) -> factureMensuel.merge(k, v, BigDecimal::add));
            return factureMensuel;
        }
    };



oemInvoices.stream()
    .reduce((oemInvoice1, oemInvoice2) -> {
        oemInvoice2.forEach((k, v) -> oemInvoice1.merge(k, v, applatirListeFactureMensuelle));
        return oemInvoice1;
    }).get();