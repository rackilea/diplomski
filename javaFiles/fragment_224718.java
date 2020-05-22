final List<PaymentTransactionsDailyFacts> list = 
            dashboardRepository.top_daily_transactions(start_datel, end_datel);

final Map<String, TopTerminalDto> map =
            list.stream()
                .collect(toMap(p -> p.getTerminal(), this::toDto))

// Conversion method
private TopTerminalDto toDto(final PaymentTransactionsDailyFacts p) {
    // Implement conversion to Dto
}