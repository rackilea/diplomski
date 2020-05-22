@Entity public class Employee {
        ...
        @TableGenerator(
            name="empGen", 
            table="ID_GEN", 
            pkColumnName="GEN_KEY", 
            valueColumnName="GEN_VALUE", 
            pkColumnValue="EMP_ID", 
            allocationSize=1)
        @Id
        @GeneratedValue(strategy=TABLE, generator="empGen")
        public int id;
        ...
    }