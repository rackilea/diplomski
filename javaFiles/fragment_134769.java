@Entity
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
})
@NamedEntityGraphs({
    @NamedEntityGraph(
        name = "studentGraph",
        attributeNodes = {
            @NamedAttributeNode(value = "id"),
            @NamedAttributeNode(value = "name"),
            @NamedAttributeNode(value = "school", subgraph = "schoolGraph")
        },
        subgraphs = {
            @NamedSubgraph(
                name = "schoolGraph",
                attributeNodes = {
                    @NamedAttributeNode("name")
                }
            )
        }
    )
})
public class Student {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    private School school;
}