@Entity
@Table(uniqueConstraints={
    @UniqueConstraint(columnNames = {"productId", "serial"})
}) 
public class InventoryItem {
    ...
}