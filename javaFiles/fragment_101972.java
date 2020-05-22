@Entity
@Table(name = "AUTHORITY_")
public class Authority implements Serializable {

    public enum Right {
        READ(100), WRITE(200), EDITOR (300);

        private int value;

        Right(int value) { this.value = value; }    

        public int getValue() { return value; }

        public static Right parse(int id) {
            Right right = null; // Default
            for (Right item : Right.values()) {
                if (item.getValue()==id) {
                    right = item;
                    break;
                }
            }
            return right;
        }

    };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUTHORITY_ID")
    private Long id;

    @Column(name = "RIGHT_ID")
    private int rightId;

    public Right getRight () {
        return Right.parse(this.rightId);
    }

    public void setRight(Right right) {
        this.rightId = right.getValue();
    }

}