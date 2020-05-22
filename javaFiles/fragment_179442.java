@Entity
@Table(name = "POSSIBLE_VALUES")
public class PossibleValues {

   @SuppressWarnings("unused")
   private static final long serialVersionUID                   = -1L;    
   public static final int   NUMBER_OF_POSSIBLE_VALUES_PLUS_ONE = 10;

   @Id
   @GeneratedValue(generator = "possibleValuesID")
   @GenericGenerator(name = "possibleValuesID", strategy = "increment")
   @Column(name = "POSSIBLE_VALUES_ID")
   private Long possibleValuesID;

   @Transient
   private SudokuPossibleValueState[] values = new SudokuPossibleValueState[NUMBER_OF_POSSIBLE_VALUES_PLUS_ONE];
   // Ugly, disgusting hack, to deal with getting an Enumerated collection in/out of JPA/Hibernate
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState zero  = SudokuPossibleValueState.UNDEFINED;
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState one   = SudokuPossibleValueState.UNDEFINED;
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState two   = SudokuPossibleValueState.UNDEFINED;
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState three = SudokuPossibleValueState.UNDEFINED;
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState four  = SudokuPossibleValueState.UNDEFINED;
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState five  = SudokuPossibleValueState.UNDEFINED;
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState six   = SudokuPossibleValueState.UNDEFINED;
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState seven = SudokuPossibleValueState.UNDEFINED;
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState eight = SudokuPossibleValueState.UNDEFINED;
   @Enumerated(EnumType.STRING)
   private SudokuPossibleValueState nine  = SudokuPossibleValueState.UNDEFINED;

   // Ugly, disgusting hack, to deal with getting an Enumerated array in/out of JPA/Hibernate
   public PossibleValues() {
      values[0] = zero;
      values[1] = one;
      values[2] = two;
      values[3] = three;
      values[4] = four;
      values[5] = five;
      values[6] = six;
      values[7] = seven;
      values[8] = eight;
      values[9] = nine;
   }

   // Ugly, disgusting hack, to deal with getting an Enumerated array in/out of JPA/Hibernate
   protected void setPossibleValue(short possibleValue, SudokuPossibleValueState state) {
      switch (possibleValue) {
         case 0: values[possibleValue] = zero = state; break;
         case 1: values[possibleValue] = one = state; break;
         case 2: values[possibleValue] = two = state; break;
         case 3: values[possibleValue] = three = state; break;
         case 4: values[possibleValue] = four = state; break;
         case 5: values[possibleValue] = five = state; break;
         case 6: values[possibleValue] = six = state; break;
         case 7: values[possibleValue] = seven = state; break;
         case 8: values[possibleValue] = eight = state; break;
         case 9: values[possibleValue] = nine = state; break;
         default: throw new RuntimeException("Possible Value [" + possibleValue + "] is illegal");
      }
   }

   // Ugly, disgusting hack, to deal with getting an Enumerated array in/out of JPA/Hibernate
   @PostLoad
   protected void syncState() {
      values[0] = zero;
      values[1] = one;
      values[2] = two;
      values[3] = three;
      values[4] = four;
      values[5] = five;
      values[6] = six;
      values[7] = seven;
      values[8] = eight;
      values[9] = nine;
   }

   public Long getPossibleValuesID() {
      return possibleValuesID;
   }

   @SuppressWarnings("unused")
   private void setPossibleValuesID(Long possibleValuesID) {
      this.possibleValuesID = possibleValuesID;
   }
}