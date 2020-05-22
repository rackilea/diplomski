@Inheritance
@DiscriminatorColumn(name="DISCRIMINATING_COLUMN")
@Table(name="SOME_TABLE")
public class Generic { ... }

// only maps records from SOME_TABLE where DISCRIMINATING_COLUMN=SOME_VALUE
@Entity
@DiscriminatorValue("SOME_VALUE")
public class firstSpecificType { ... } 

// only maps records from SOME_TABLE where DISCRIMINATING_COLUMN=OTHER_VALUE
@Entity
@DiscriminatorValue("OTHER_VALUE")
public class secondSpecificType { ... }