@Entity
public class Fee implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(unique = true, nullable = false)
private Long id;

@Column(nullable = false, length = 1)
private String isValid;

...

 @Override
 public boolean equals(Object arg0) {
    if (!(arg0 instanceof Fee))
        return false;
    Fee f0 = (Fee) arg0;
    return f0.getId().equals(this.getId());
  }
}