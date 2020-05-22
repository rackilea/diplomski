@Entity
@Data
public class PurchaseOrder {
      @Id
      @GeneratedValue
      Long id;

      //  You need to set the mappedBy attribute to the field name
      //  of PurchaseOrder in PlantReservation
      //  Update: omit mappedBy if PurchaseOrder is not mapped in PlantReservation
      @OneToMany(mappedBy="order")
      List<PlantReservation> reservations;

      @ManyToOne
      PlantInventoryEntry plant;

      LocalDate issueDate;
      LocalDate paymentSchedule;
      @Column(precision=8,scale=2)
      BigDecimal total;

      @Enumerated(EnumType.STRING)
      POStatus status;
      LocalDate startDate;
      LocalDate endDate;
    }