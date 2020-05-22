@Entity
@Table(name = "terminal")
@SecondaryTable(name = "terminaldetails")
public class TerminalEntity {
     @Id
     @GeneratedValue
     private Long id;

     @Column(name = "terminal_id")
     private String terminalId;

     @Column(name = "terminal_name", table = "terminaldetails")
     private String terminalName;
}