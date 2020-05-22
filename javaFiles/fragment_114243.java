import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLTypeReference;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

public class GraphQLTypes {

     private GraphQLObjectType studentType;
     private GraphQLObjectType classType;

    public GraphQLTypes() {
        createStudentType();
        createClassType();
    }

    void createStudentType() {
        studentType = newObject().name("Student")
                .field(newFieldDefinition().name("name").type(GraphQLString).build())
                .field(newFieldDefinition().name("currentClass").type(new GraphQLTypeReference("Class")).build())
                .build();
    }

    void createClassType() {
        classType = newObject().name("Class")
                .field(newFieldDefinition().name("name").type(GraphQLString).build())
                .field(newFieldDefinition().name("students").type(new GraphQLList(studentType)).build())
                .build();
    }

}