private final RelationshipType relationshipType;
private final Direction direction;
private final Integer times;

public customExpander (RelationshipType relationshipType, Direction direction ,Integer times)
{
    this.relationshipType = relationshipType;
    this.direction = direction;
    this.times=times;
}



@Override
public Iterable<Relationship> expand(Path path, BranchState state)
{
        List<Relationship> results = new ArrayList<Relationship>();
        for ( Relationship r : path.endNode().getRelationships( relationshipType, direction ) )
        {  
           results.add( r ); 
        }
        Collections.shuffle(results);
        }       
    return results;         
    }


@Override
public PathExpander<String> reverse()
{
    return null;
}