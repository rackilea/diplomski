public enum DonationType {
  ADOPTION, APPOINTMENT, EXAM;
}

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", 
  discriminatorType = DiscriminatorType.STRING)
public abstract class Donation {
     @Enumerated(EnumType.STRING)
     private DonationType type;

     @JsonIgnore
     @OneToMany(fetch = FetchType.LAZY)
     private List<Voucher> vouchers;
}

@Entity
@DiscriminatorValue(DonationType.ADOPTION)
public class Adoption extends Donation {
}

@Entity
@DiscriminatorValue(DonationType.Exam)
public class Exam extends Donation {
}

@Entity
@DiscriminatorValue(DonationType.APPOINTMENT)
public class Appointment extends Donation {
}

@Entity
public class Voucher {
   //could be single mapping just to supperclass, depends on logic what do you need
   @ManyToOne
   private Adoption adoption;

   @ManyToOne
   private Exam exam;

   @ManyToOne
   private Appointment exam;

}