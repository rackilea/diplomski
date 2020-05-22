@Getter @Setter
@Entity
@Table(name = "payments")
public class PaymentEntity {
  ...
  @Convert(converter = PaymentStatusesConverter.class)
  private PaymentStatuses status;
  ...    
}

public class PaymentStatusesConverter  implements AttributeConverter<PaymentStatuses, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PaymentStatuses status) {
        return status.getId();
    }

    @Override
    public PaymentStatuses convertToEntityAttribute(Integer status) {
         return PaymentStatuses.valueOf(status); 
    }
}