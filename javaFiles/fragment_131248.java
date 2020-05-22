public class LocalDateConverter extends BidirectionalConverter<LocalDate, LocalDate> {

  @Override
  public LocalDate convertTo(LocalDate source, Type<LocalDate> destinationType) {
    return (LocalDate.from(source));
  }

  @Override
  public LocalDate convertFrom(LocalDate source, Type<LocalDate> destinationType) {
    return (LocalDate.from(source));
  }

}